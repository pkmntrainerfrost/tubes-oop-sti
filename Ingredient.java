public class Ingredient extends Foods {

    public Ingredient(String name, int fullness, int price) {
        super(name, fullness, price, true);
        this.setPrice(price);
        this.setBuyable(true);
    }

    @Override
    public String getCategory() {
        return "Ingredients";
    }

/*
    @Override
    public void setItemName(String itemName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setItemName'");
    }
    
    @Override
    public String getItemName() {
        return this.getName();
    }
*/
}