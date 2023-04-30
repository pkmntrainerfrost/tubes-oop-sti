public class Mandi extends SimActiveAction {
    
    public Mandi(int duration, Sim sim) {
        super(sim, duration);
    }

    public Mandi(Sim sim) {
        super(sim);
    }

    @Override
    public void finish() {
        int time = getDuration()/240;
        getSim().setMood(getSim().getMood() + time * 10);
        getSim().setKesehatan(getSim().getKesehatan() + time * 10);
    }
}