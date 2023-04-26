public class Exercise extends SimActiveAction {
    public Exercise(int duration, Sim sim) {
        super(sim, duration);
    }

    public void finish() {
        int time = getDuration()/20;
        for (int i = 0; i < time; i++){
            getSim().setKesehatan(getSim().getKesehatan()+5);
            getSim().setKekenyangan(getSim().getKekenyangan()-5);
            getSim().setMood(getSim().getMood()+10);
        }
    }
}