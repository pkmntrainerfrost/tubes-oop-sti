public class Eat extends SimActiveAction {
    private boolean finished;
    private Food itemMakanan;

    public Eat(Sim sim, Food itemMakanan) {
        super(sim,30);
        this.itemMakanan = itemMakanan;
        this.finished = false;
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

    public void setStatusFinished(boolean finished){
        this.finished = finished;
    }

    public void setItemMakanan(Food itemMakanan) {
        this.itemMakanan = itemMakanan;
    }

    @Override
    public void finish() {
        while (!getStatusFinish()){
            getSim().setKekenyangan(getSim().getKekenyangan() + itemMakanan.getFullness());
            // getSim().getSimInventory().removeItem(itemMakanan.getItemName(), 1); <-- butuh inventory
        }
        this.finished = true;
    }
}