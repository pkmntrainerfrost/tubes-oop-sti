import java.util.ArrayList;

public class Cook extends SimActiveAction {
    Food itemMakanan;
    static ArrayList<String> listDimasak = new ArrayList<String>();

    public Cook(Sim sim, Food itemMakanan){
        super(sim);
        this.itemMakanan = itemMakanan;
        setDuration((int)1.5 * 1); //SEMENTARA
        listDimasak.add(itemMakanan.getItemName());
    }

    @Override
    public void finish() {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Kompor Gas") || getSim().getCurrentRoom().getItemListInRoom().contains("Kompor Listrik") ){
            for (int i = 0; i < listDimasak.size(); i++){
                getSim().setMood(getSim().getMood()+10);
            }
        }
        listDimasak.remove(itemMakanan.getItemName());
    }
}