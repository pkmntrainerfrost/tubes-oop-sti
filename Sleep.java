public class Sleep extends SimActiveAction {
    public Sleep(Sim sim, int duration){
        super(sim,duration);
    }
    public Sleep(Sim sim) {
        super(sim);
    }

    @Override
    public void finish() {
        int duration = getDuration()/60;
        if (duration >= 3) {
            int time = getDuration()/240;
            getSim().setMood(getSim().getMood() + (time * 30));
            getSim().setKesehatan(getSim().getKesehatan() + (time * 20));
        } else {
            getSim().setMood(getSim().getMood() - 5);
            getSim().setKesehatan(getSim().getKesehatan() - 5);
        }
    }
}