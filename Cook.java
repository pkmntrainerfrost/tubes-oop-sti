public class Cook extends Action {
    private int duration;
    public Cook(int duration, Sim sim){
        super(sim);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void acted() {
        int time = getDuration();
        for (int i = 0; i < time; i++){
            getSim().setMood(getSim().getMood()+10);
        }
    }
}