public class Dance extends SimActiveAction {

    public Dance(Sim sim, int duration) {
        super(sim, duration);
    }

    public void finish() {
        int time = getDuration()/60;
        getSim().setMood(getSim().getMood() + time * 6);
        getSim().setKekenyangan(getSim().getKekenyangan() - time * 6);
    }

}