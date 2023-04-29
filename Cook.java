public class Cook extends SimActiveAction {
    Food itemMakanan;
    public Cook(Sim sim){
        super(sim);
        setDuration((int)1.5 * 1); //SEMENTARA
    }

    @Override
    public void finish() {
        getSim().setMood(getSim().getMood()+10);
    }
}