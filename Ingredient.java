public class Ingredient extends Food implements Items {

    public Ingredient(String name, int fullness, int price) {
        super(name, fullness);
        this.setPrice(price);
        this.setBuyable(true);
    }

    @Override
    public String getItemName() {
        return this.name;
    }

    @Override
    public String getCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategory'");
    }

    @Override
    public void setItemName(String itemName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setItemName'");
    }

}