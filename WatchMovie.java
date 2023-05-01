public class WatchMovie extends SimActiveAction {
    public WatchMovie(int duration, Sim sim) {
        super(sim, duration);
    }

    public void finish() {
        int time = getDuration()/3600;
        getSim().setMood(getSim().getMood() + time * 10);
        getSim().setKesehatan(getSim().getKesehatan() - time * 2);
        getSim().setKekenyangan(getSim().getKekenyangan() - time * 2);
    }
}