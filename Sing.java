public class Sing extends ActiveAction {

    public Sing(Sim sim, int duration) {
        super(sim, duration);
    }

    public void finish() {
        int moodIncrease = 10;
        int duration = this.getDuration();
        this.getSim().setMood(this.getSim().getMood() + (moodIncrease * (duration / 10)));
        this.getSim().setMusicSkill(this.getSim().getMusicSkill() + (duration / 10));
    }
    
}