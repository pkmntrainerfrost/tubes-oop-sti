public class ThrowRubbish extends SimActiveAction {
    public ThrowRubbish(int duration, Sim sim) {
        super(sim, duration);
    }

    public ThrowRubbish(Sim sim) {
        super(sim);
    }

    public void finish() {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("RubbishBin")){
            int time = getDuration()/60;
            getSim().setMood(getSim().getMood() + time * 5);
            getSim().setKesehatan(getSim().getKesehatan() - time * 5);
        }
    }
}
