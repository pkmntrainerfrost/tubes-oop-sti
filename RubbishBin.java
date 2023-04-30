public class RubbishBin extends FurnitureType {
    public RubbishBin(Sim sim){
        super("RubbishBin", 2, 3, 40, new ThrowRubbish(sim));
    }
}
