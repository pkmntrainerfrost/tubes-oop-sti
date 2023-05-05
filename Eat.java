import java.util.*;

public class Eat extends SimActiveAction {
    
    private Food itemMakanan;

    public void begin(Sim sim) {
        System.out.print("input the food " + sim.getName() + " want to eat: ");
        Scanner scan = new Scanner(System.in);
        String eat = scan.next();
        this.setDuration(10);
        if (sim.getInventory().equals(eat)) {
            System.out.println("eat successfully");
        } else {
            System.out.println("food doesn't exist");
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