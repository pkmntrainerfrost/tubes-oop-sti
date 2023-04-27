public class Sleep extends SimActiveAction {

    public Sleep(Sim sim, int duration){
        super(sim,duration);
    }

    public void finish() {
        int time = getDuration()/240;
        getSim().setMood(getSim().getMood() + time * 30);
        getSim().setKesehatan(getSim().getKesehatan() + time * 20);
    }
}