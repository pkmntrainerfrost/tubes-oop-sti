public class Mattress extends FurnitureType {
    public Mattress(Sim sim){
        super("Mattress", 5, 3, 10, new Meditation(sim));
    }
}
