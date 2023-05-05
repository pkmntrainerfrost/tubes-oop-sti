public abstract class SimActiveAction implements SimAction {

    private int duration;
    private int endTime;

    public abstract void begin(Sim sim);
    
    public void execute(Sim sim) {
        begin(sim);
        process(sim);
        end(sim);
    }

    public void process(Sim sim) {

        endTime = Clock.getInstance().getSeconds() + duration;

        int currentTime = Clock.getInstance().getSeconds();

        Clock.getInstance().startClock();

        while (currentTime < endTime) {
            currentTime = Clock.getInstance().getSeconds();
        }

        if (Game.getInstance().getActionMap().isEmpty()) {
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

}
