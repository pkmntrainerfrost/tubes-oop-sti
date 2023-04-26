public class BuangSampah extends SimActiveAction {
    public BuangSampah(int duration, Sim sim) {
        super(sim, duration);
    }

    @Override
    public void finish() {
        int time = getDuration() / 10;
        for (int i = 0; i < time; i++) {
            getSim().setMood(getSim().getMood() + 5);
            getSim().setKesehatan(getSim().getKesehatan() + 5);
        }
    }
}