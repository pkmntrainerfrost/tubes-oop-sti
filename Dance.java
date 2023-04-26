public class Dance extends SimActiveAction {

    public Dance(Sim sim, int duration) {
        super(sim, duration);
    }

    public void finish() {
        getSim().setMood(getSim().getMood() + 3);
    }

}