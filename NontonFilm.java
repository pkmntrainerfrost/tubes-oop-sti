public class NontonFilm extends SimActiveAction {
    public NontonFilm(int duration, Sim sim) {
        super(sim, duration);
    }

    public void finish() {
        int time = getDuration()/3600;
        getSim().setMood(getSim().getMood() + time * 10);
        getSim().setKesehatan(getSim().getKesehatan() - time * 2);
        getSim().setKekenyangan(getSim().getKekenyangan() - time * 2);
    }
}