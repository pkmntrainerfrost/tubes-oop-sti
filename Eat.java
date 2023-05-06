import java.util.*;

public class Eat extends SimActiveAction {
    
    private Food itemMakanan;

    public void begin(Sim sim) {
        System.out.print("input the food " + sim.getName() + " want to eat: ");
        Scanner scan = new Scanner(System.in);
        String eat = scan.next();

        CommandLine cli = new CommandLine();

        while (cli.validateInputString(eat)){
            System.out.print("input the food " + sim.getName() + " want to eat: ");
            eat = scan.next();
        }
        /* mengecek apakah inputan eat ada atau tidak */
        for (InventoryItem makanan : sim.getInventory().getItem()) {
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

    public void end(Sim sim) {

        sim.setKekenyangan(sim.getKekenyangan() + (itemMakanan.getFullness()));
        sim.getInventory().removeItem(itemMakanan.getItemName(), 1);
        sim.setPeeCycle(true);
    }

    /*
    public Eat(Sim sim, Food itemMakanan, int duration) {
        super(sim);
        this.itemMakanan = itemMakanan;
        this.finished = false;
        this.duration = duration;
    }

    public Eat(Sim sim) {
        super(sim);
    }

    public Food getItemMakanan() {
        return itemMakanan;
    }

    public boolean getStatusFinish() {
        return finished;
    }

    public void setItemMakanan(Food itemMakanan) {
        this.itemMakanan = itemMakanan;
    }

    @Override
    public void finish() {
        getSim().setKekenyangan(getSim().getKekenyangan() + (itemMakanan.getFullness()*duration/30));
        // getSim().getSimInventory().removeItem(itemMakanan.getItemName(), 1); <-- butuh inventory
        this.finished = true;
    }
    */

}