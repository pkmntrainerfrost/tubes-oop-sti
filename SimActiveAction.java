public abstract class SimActiveAction implements SimAction {

    private int duration;
    private int endTime;
    private boolean finished = false;

    public abstract void begin(Sim sim);
    
    public void execute(Sim sim) {
        begin(sim);
        process(sim);
        end(sim);
    }

    public void process(Sim sim) {

        endTime = Clock.getInstance().getSeconds() + duration;
        
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

    }

    public abstract void end(Sim sim);

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
