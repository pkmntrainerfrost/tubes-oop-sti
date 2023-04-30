public abstract class SimActiveAction implements SimAction {
    private Sim sim;
    private int duration;


    public SimActiveAction(Sim sim, int duration) {
        this.sim = sim;
        this.duration = duration;
    }

    public SimActiveAction(Sim sim) {
        this.sim = sim;
    }

    public void run() {
        act();
        finish();
    }

    public void act() {
        int endTime = Clock.getInstance().getSeconds() + duration;
        int currentTime = Clock.getInstance().getSeconds();

        SimActionMediator.getInstance().addAction(this);

        while (currentTime < endTime) {
            currentTime = Clock.getInstance().getSeconds();
        }
    }

    public abstract void finish();

    /* getter */
    public Sim getSim() {
        return sim;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
