public class Minum extends SimActiveAction {
    public Minum(int duration, Sim sim) {
        super(sim, duration);
    }

    public void finish() {
        int time = getDuration()/2;
        getSim().setKesehatan(getSim().getKesehatan() + time * 2);
        getSim().setKekenyangan(getSim().getKekenyangan() + time * 1);
    }
}