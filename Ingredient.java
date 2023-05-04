public class Ingredient extends Food {

    public Ingredient(String name, int fullness, int price) {
        super(name, price, fullness);
        this.setBuyable(true);
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