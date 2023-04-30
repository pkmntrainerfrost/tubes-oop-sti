public class Mic extends FurnitureType{
    public Mic(Sim sim) {
        super("Mic", 1, 1, 40, new Sing(sim));
    }
}
