public class Eat extends SimActiveAction {

    private Food itemMakanan;

    public Eat(Sim sim, Food itemMakanan) {
        super(sim,30);
        this.itemMakanan = itemMakanan;
    }

    public Food getItemMakanan() {
        return itemMakanan;
    }

    public void setItemMakanan(Food itemMakanan) {
        this.itemMakanan = itemMakanan;
    }

    public void finish() {
        getSim().setKekenyangan(getSim().getKekenyangan() + itemMakanan.getFullness());
    }

    /*
    @Override
    public void acted() {
        int time = getDuration()/30;
        int itemQuantity = getSim().getSimInventory().getItemQuantity(getItemMakanan().getItemName());
        
        for (int i = 0; i < time; i++) {
            if (itemQuantity >= 1) {
                if (getItemMakanan().getItemName().equals("Nasi")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+5);
                    getSim().getSimInventory().removeItem("Nasi", 1);
                } else if (getItemMakanan().getItemName().equals("Kentang")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+4);
                    getSim().getSimInventory().removeItem("Kentang", 1);
                } else if (getItemMakanan().getItemName().equals("Ayam")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+8);
                    getSim().getSimInventory().removeItem("Ayam", 1);
                } else if (getItemMakanan().getItemName().equals("Sapi")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+15);
                    getSim().getSimInventory().removeItem("Sapi", 1);
                } else if (getItemMakanan().getItemName().equals("Wortel")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+2);
                    getSim().getSimInventory().removeItem("Wortel", 1);
                } else if (getItemMakanan().getItemName().equals("Bayam")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+2);
                    getSim().getSimInventory().removeItem("Bayam", 1);
                } else if (getItemMakanan().getItemName().equals("Kacang")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+2);
                    getSim().getSimInventory().removeItem("Kacang", 1);
                } else if (getItemMakanan().getItemName().equals("Susu")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+1);
                    getSim().getSimInventory().removeItem("Susu", 1);
                } else {
                    System.out.println("Makanan tidak ada di list");
                }
            } else {
                System.out.println("Makanan sudah habis");
            }
        }
    }
    */
}