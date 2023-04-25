public class Eat extends Action{
    private String makanan;

    public Eat(String makanan, int duration, Sim sim) {
        super(sim,duration);
        this.makanan = makanan;
    }

    public String getMakanan() {
        return makanan;
    }

    public void setMakanan(String makanan) {
        this.makanan = makanan;
    }

    @Override
    public void acted() {
        int time = getDuration()/30;
        int itemQuantity = getSim().getInventory().getItemQuantity(makanan);
        
        for (int i = 0; i < time; i++) {
            if (itemQuantity >= 1) {
                if (getMakanan().equals("Nasi")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+5);
                    getSim().getInventory().removeItem("Nasi", 1);
                } else if (getMakanan().equals("Kentang")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+4);
                    getSim().getInventory().removeItem("Kentang", 1);
                } else if (getMakanan().equals("Ayam")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+8);
                    getSim().getInventory().removeItem("Ayam", 1);
                } else if (getMakanan().equals("Sapi")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+15);
                    getSim().getInventory().removeItem("Sapi", 1);
                } else if (getMakanan().equals("Wortel")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+2);
                    getSim().getInventory().removeItem("Wortel", 1);
                } else if (getMakanan().equals("Bayam")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+2);
                    getSim().getInventory().removeItem("Bayam", 1);
                } else if (getMakanan().equals("Kacang")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+2);
                    getSim().getInventory().removeItem("Kacang", 1);
                } else if (getMakanan().equals("Susu")) {
                    getSim().setKekenyangan(getSim().getKekenyangan()+1);
                    getSim().getInventory().removeItem("Susu", 1);
                } else {
                    System.out.println("Makanan tidak ada di list");
                }
            } else {
                System.out.println("Makanan sudah habis");
            }
        }
    }
}