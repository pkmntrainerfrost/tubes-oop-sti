public class Toilet extends FurnitureType {
    public Toilet(Sim sim) {
        super("Toilet", 1, 1, 50, new Pee(sim));
    }  
}
