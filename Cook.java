public class Cook extends ActiveAction {

    public Cook(Sim sim){
        super(sim);
        setDuration(1.5 * 1); // SEMENTARA
    }

    @Override
    public void acted() {
        int time = getDuration();
        for (int i = 0; i < time; i++){
            getSim().setMood(getSim().getMood()+10);
        }
    }
}