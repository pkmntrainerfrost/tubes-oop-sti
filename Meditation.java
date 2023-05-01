public class Meditation extends SimActiveAction {
    public Meditation(int duration, Sim sim) {
        super(sim, duration);
    }

    public Meditation(Sim sim) {
        super(sim);
    }

    public void finish() {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Mattress")){
            int time = getDuration()/600;
            getSim().setMood(getSim().getMood() + time * 5);
            getSim().setKesehatan(getSim().getKesehatan() + time * 5);
        }
    }
}