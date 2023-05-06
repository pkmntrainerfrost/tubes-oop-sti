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

        System.out.println(endTime);

        Clock.getInstance().startClock();
        
        new Thread(() -> {
            while (Clock.getInstance().getSeconds() <= endTime) {
            }
            if (Game.getInstance().getPassiveAction().isEmpty()) {
                Clock.getInstance().stopClock();
            }
            finished = true;
        }).start();

        while (!finished) {
            System.out.println(".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
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
