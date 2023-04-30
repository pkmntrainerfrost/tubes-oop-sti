public class Bookcase extends FurnitureType {
    public Bookcase(Sim sim){
        super("Bookcase", 2, 3, 75, new ReadBook(sim));
    }
}
