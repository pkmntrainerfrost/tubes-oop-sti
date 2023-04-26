public class Sleep extends Action {
    private int duration;

    public Sleep(Sim sim){
        super(sim);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void acted() {
        int time = getDuration()/240;
        for (int i = 0; i < time; i++){
            getSim().setKekenyangan(getSim().getMood()+30);
            getSim().setMood(getSim().getKesehatan()+20);
        }
    }
}