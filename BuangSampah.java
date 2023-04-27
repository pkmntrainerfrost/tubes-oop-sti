public class BuangSampah extends SimActiveAction {
    public BuangSampah(int duration, Sim sim) {
        super(sim, duration);
    }

    public void finish() {
        int time = getDuration()/60;
        getSim().setMood(getSim().getMood() + time * 5);
        getSim().setKesehatan(getSim().getKesehatan() - time * 5);
    }

/*
    @Override
    public void finish() {
        int time = getDuration() / 10;
        for (int i = 0; i < time; i++) {
            getSim().setMood(getSim().getMood() + 5);
            getSim().setKesehatan(getSim().getKesehatan() + 5);
        }
*/

}