public abstract class SimActiveAction implements SimAction {

    private int duration;
    private int endTime;

    public void run(Sim sim) {
        act(sim);
        end(sim);
    }

    public void act(Sim sim) {

        endTime = Clock.getInstance().getSeconds() + duration;

        int currentTime = Clock.getInstance().getSeconds();

        Mediator.getInstance().addAction(sim,this);

        while (currentTime < endTime) {
            currentTime = Clock.getInstance().getSeconds();
        }
    }

    public abstract void end(Sim sim);

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
