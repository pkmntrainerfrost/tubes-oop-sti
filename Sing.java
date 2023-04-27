public class Sing extends SimActiveAction {

    public Sing(Sim sim, int duration) {
        super(sim, duration);
    }

    public void finish() {
        int time = getDuration()/60;
        getSim().setMood(getSim().getMood() + time * 5);
        getSim().setKekenyangan(getSim().getKekenyangan() - time * 5);
    }

}