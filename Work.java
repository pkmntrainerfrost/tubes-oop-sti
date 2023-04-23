public class Work extends Action{
    private int duration;
    public Work(int duration, Sim sim) {
        super(sim);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
    
    @Override
    public void acted() {
        int time = getDuration()/30;
        for (int i = 0; i < time; i++){
            getSim().setKekenyangan(getSim().getKekenyangan()-10);
            getSim().setMood(getSim().getMood()-10);
        }
    }
}