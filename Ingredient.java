public class Ingredient extends Food implements Item {

    public Ingredient(String name, int fullness, int price) {
        super(name, fullness);
        this.setPrice(price);
        this.setBuyable(true);
    }

}