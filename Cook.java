import java.util.ArrayList;
import java.util.*;

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
        System.out.println("input recipe's name: ");
        Scanner scan = new Scanner(System.in);
        String recipeName = scan.next();

        if(recipe.getItemName().equals(recipeName)){
            
        }
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