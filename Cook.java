public class Cook extends SimActiveAction {
    Food itemMakanan;
    public Cook(Sim sim){
        super(sim);
        setDuration((int)1.5 * 1); //SEMENTARA
    }

    @Override
    public void finish() {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Kompor Gas") || getSim().getCurrentRoom().getItemListInRoom().contains("Kompor Listrik") ){
            getSim().setMood(getSim().getMood()+10);
        }
    }
}