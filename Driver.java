public class Driver {
    public static void main(String[] args){
        Sim sim1 = new Sim("tata");
        Inventory inv = new Inventory();
        inv.addItem(new QueenSizeBed(sim1), 2);
    }
}
