public class ElectricStove extends FurnitureType {
    public ElectricStove(Sim sim) {
        super("Kompor Listrik", 1, 1, 200, new Cook(sim));
    }
}
