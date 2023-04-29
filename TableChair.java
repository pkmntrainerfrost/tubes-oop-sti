public class TableChair extends FurnitureType {
    public TableChair(Sim sim) {
        super("Meja dan Kursi", 3, 3, 50, new Eat(sim));
    }
}
