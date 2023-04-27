public class Cook extends SimActiveAction {

    public Cook(Sim sim){
        super(sim);
        setDuration((int)1.5 * 1); // SEMENTARA
    }

    @Override
    public void finish() {
        int time = getDuration();
        for (int i = 0; i < time; i++){
            getSim().setMood(getSim().getMood()+10);
        }
    }
}