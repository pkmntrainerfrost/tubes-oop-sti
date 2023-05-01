public class TakeBath extends SimActiveAction {
    
    public TakeBath(int duration, Sim sim) {
        super(sim, duration);
    }

    public TakeBath(Sim sim) {
        super(sim);
    }

    @Override
    public void finish() {
        int time = getDuration()/240;
        getSim().setMood(getSim().getMood() + time * 10);
        getSim().setKesehatan(getSim().getKesehatan() + time * 10);
    }
}