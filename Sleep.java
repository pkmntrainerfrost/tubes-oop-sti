public class Sleep extends SimActiveAction {

    public Sleep(Sim sim, int duration){
        super(sim,duration);
    }

    public void finish() {
        int time = getDuration()/240;
        getSim().setMood(getSim().getMood() + time * 30);
        getSim().setKesehatan(getSim().getKesehatan() + time * 20);
    }

    /*
    @Override
    public void acted() {
        int time = getDuration()/240;
        for (int i = 0; i < time; i++){
            getSim().setKekenyangan(getSim().getMood()+30);
            getSim().setMood(getSim().getKesehatan()+20);
        }
    }
    */
}