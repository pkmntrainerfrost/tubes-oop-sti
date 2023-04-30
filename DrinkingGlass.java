public class DrinkingGlass extends FurnitureType {
    public DrinkingGlass(Sim sim){
        super("DrinkingGlass", 1, 1, 5, new Drink(sim));
    }
}
