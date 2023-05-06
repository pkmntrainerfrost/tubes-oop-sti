public abstract class SimActiveAction implements SimAction {

    private int duration;
    private int endTime;
    private boolean finished = false;
    private boolean cancelled = false;

    public abstract void begin(Sim sim);
    
    public void execute(Sim sim) {
        begin(sim);
        if (!cancelled) {
            process(sim);
            end(sim);
        }
    }

    public void process(Sim sim) {

        endTime = Clock.getInstance().getSeconds() + duration;

        Clock.getInstance().startClock();
        
        new Thread(() -> {
            int currentTime = Clock.getInstance().getSeconds();
            while (currentTime < endTime) {
                currentTime = Clock.getInstance().getSeconds();
            }
            finished = true;
        }).start();

        while (!finished) {
            System.out.println("."); 
        }

        if (Game.getInstance().getPassiveAction().isEmpty()) {
            Clock.getInstance().stopClock();
        }

    }

    public abstract void end(Sim sim);

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }   

    public void addDuration(int duration) {
        this.duration += duration;
    }

    public boolean getCancelled() {
        return cancelled;
    }
    
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

}
