import java.util.ArrayList;

public class Cook extends SimActiveAction {
    
    private Recipe recipe;

    /*
    public Cook(Sim sim, Food itemMakanan){
        super(sim);
        this.itemMakanan = itemMakanan;
        setDuration((int)1.5 * 1); //SEMENTARA
        listDimasak.add(itemMakanan.getItemName());
    }
    */

    public void begin(Sim sim) {
        /* MASUKIN INPUTNYA COK */
    }

    @Override
    public void end(Sim sim) {
        sim.setMood(sim.getMood() + 10);
        recipe.cook(sim.getInventory());
        sim.getInventory().addItem(recipe, 1);
        /*
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Kompor Gas") || getSim().getCurrentRoom().getItemListInRoom().contains("Kompor Listrik") ){
            for (int i = 0; i < listDimasak.size(); i++){
                getSim().setMood(getSim().getMood()+10);
            }
        }
        listDimasak.remove(itemMakanan.getItemName());
        */
    }
}