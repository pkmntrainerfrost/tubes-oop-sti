public abstract class ActiveAction implements Action {
    
    private Sim sim;
    private int duration;

    public ActiveAction(Sim sim, int duration) {
        this.sim = sim;
        this.duration = duration;
    }

    public ActiveAction(Sim sim) {
        this.sim = sim;
    }

    public void run() {

        act();
        finish();

    }

    public void act() {

        int endTime = Clock.getInstance().getSeconds() + duration;
        int currentTime = Clock.getInstance().getSeconds();

        ActionMediator.getInstance().addAction(this);

        while (currentTime < endTime) {
            currentTime = Clock.getInstance().getSeconds();
        }

    }

    public abstract void finish();

    // getter
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
