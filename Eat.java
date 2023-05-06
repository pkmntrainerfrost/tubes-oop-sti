import java.util.*;

public class Eat extends SimActiveAction {
    
    private Food itemMakanan;

    public void begin(Sim sim) {
        boolean validpos = true;
        if (sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition()) == null) {
            validpos = false;
        } else {
            FurnitureObject furniture = (FurnitureObject) sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition());
            if (!(furniture.getFurniture().getAction().equals("Eat"))) {
                validpos = false;
            }
        }
        if (!validpos) {
            System.out.println("You are not on the correct object!");
            setCancelled(true);
        } else {
        System.out.println("here is the food list in inventory");
        //Map<String, Integer> mapIng = new HashMap<>();
        //mapIng.put("Nasi", 10);
        //mapIng.put("Ayam", 5);
        //sim.getInventory().addItem(new Recipe("Nasi Ayam", 10, mapIng) , 10);
        for (InventoryItem invItem : sim.getInventory().getArrayInventoryItem()) {
            if (invItem.getCategory().equals("Food")){
                //System.out.println("TESTER");
                System.out.println("=================================================================");
                System.out.println("||" + invItem.getName() + "||" + invItem.getQuantity() + "||" + invItem.getCategory());
            }
        }
        System.out.println();
        System.out.print("input the food " + sim.getName() + " want to eat: ");
        Scanner scan = new Scanner(System.in);
        String eat = scan.next();

        CommandLine cli = new CommandLine();

        while (cli.validateInputString(eat)){
            System.out.print("input the food " + sim.getName() + " want to eat: ");
            eat = scan.next();
        }
        /* mengecek apakah inputan eat ada atau tidak */
        for (InventoryItem makanan : sim.getInventory().getArrayInventoryItem()) {
            if (makanan.getCategory().equals("Food")) {
                if (makanan.getName().equals(eat)) {
                    System.out.println("eat successfully");
                    this.setDuration(10);
                } else {
                    System.out.println("food doesn't exist");
                    this.setCancelled(true);
                }
            } else {
                System.out.println(makanan.getName() +" input is not a Food!");
                this.setCancelled(true);
            }
        }
        }
    }

    public void end(Sim sim) {

        sim.setKekenyangan(sim.getKekenyangan() + (itemMakanan.getFullness()));
        sim.getInventory().removeItem(itemMakanan.getItemName(), 1);
        sim.setPeeCycle(true);
    }


}