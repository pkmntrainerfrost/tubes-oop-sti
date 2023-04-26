public class Sing extends ActiveAction {

    public Sing(Sim sim, int duration) {
        super(sim, duration);
    }

    public void finish() {
        getSim().setMood(getSim().getMood() + 5);
    }

}