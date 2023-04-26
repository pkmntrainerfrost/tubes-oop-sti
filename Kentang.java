public class Kentang extends Food {
    
    public Kentang() {
        super("Kentang", 4, 3);
    }

    @Override
    public String getItemName() {
        // TODO Auto-generated method stub
        return getName();
    }

    @Override
    public String getCategory() {
        // TODO Auto-generated method stub
        return getCategory();
    }

    @Override
    public void setItemName(String itemName) {
        // TODO Auto-generated method stub
        setName(itemName);
    }
}