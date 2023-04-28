public class Exercise extends SimActiveAction {
    public Exercise(int duration, Sim sim) {
        super(sim, duration);
    }

    @Override
    public void finish() {
        int time = getDuration()/20;
        getSim().setKesehatan(getSim().getKesehatan() + (time * 5));
        getSim().setKekenyangan(getSim().getKekenyangan() - (time * 5));
        getSim().setMood(getSim().getMood() + (time * 10));
    }
}