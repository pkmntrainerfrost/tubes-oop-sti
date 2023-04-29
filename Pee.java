public class Pee extends SimActiveAction {
    private Eat eat;
    public Pee(Sim sim){
        super(sim,10);
    }

    @Override
    public void finish() {
        int time = getDuration()/10;
        // ini masih belum ada efek tidak buang air (masih bingung)
        if (eat.getStatusFinish() == true) {
            getSim().setKekenyangan(getSim().getKekenyangan() - (time * 20));
            getSim().setMood(getSim().getMood() + (time * 10));
        }
    }
}