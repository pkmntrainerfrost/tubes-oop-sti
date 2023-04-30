public class Treadmill extends FurnitureType{
    public Treadmill(Sim sim){
        super("Treadmill", 3, 2, 250, new Exercise(sim));
    }
}
