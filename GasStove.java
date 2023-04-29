public class GasStove extends FurnitureType {
    public GasStove(Sim sim) {
        super("Kompor Gas", 2, 1, 100, new Cook(sim));
    }
}
