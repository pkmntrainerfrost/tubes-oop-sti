public class Pee extends Action {

    public Pee(Sim sim){
        super(sim,10);
    }

    @Override
    public void acted() {
        int time = getDuration()/10;
        for (int i = 0; i < time; i++){
            getSim().setKekenyangan(getSim().getKekenyangan()-20);
            getSim().setMood(getSim().getMood()+10);
        }
    }
}