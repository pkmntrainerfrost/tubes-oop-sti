public class Exercise extends Action {
    private int duration;
    public Exercise(int duration, Sim sim) {
        super(sim);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void acted() {
        int time = getDuration()/20;
        for (int i = 0; i < time; i++){
            getSim().setKesehatan(getSim().getKesehatan()+5);
            getSim().setKekenyangan(getSim().getKekenyangan()-5);
            getSim().setMood(getSim().getMood()+10);
        }
    }
}