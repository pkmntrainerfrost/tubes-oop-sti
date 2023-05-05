public class Eat extends SimActiveAction {
    
    private Food itemMakanan;

    public void begin(Sim sim) {
        System.out.print("input the food " + sim.getName() + " want to eat: ");
        if ()
    }

    public void end(Sim sim) {
        sim.setKekenyangan(sim.getKekenyangan() + (itemMakanan.getFullness()));
        sim.getInventory().removeItem(itemMakanan.getItemName(), 1);
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