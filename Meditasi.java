public class Meditasi extends SimActiveAction {
    public Meditasi(int duration, Sim sim) {
        super(sim, duration);
    }

    public void finish() {
        int time = getDuration()/600;
        getSim().setMood(getSim().getMood() + time * 5);
        getSim().setKesehatan(getSim().getKesehatan() + time * 5);
    }
}