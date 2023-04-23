public class Pee extends Action {
    private int duration;

    public Pee(Sim sim){
        super(sim);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void acted() {
        int time = getDuration()/10;
        for (int i = 0; i < time; i++){
            getSim().setKekenyangan(getSim().getKekenyangan()-20);
            getSim().setMood(getSim().getMood()+10);
        }
    }
}