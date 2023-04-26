public class Susu extends Food {
    
    public Susu() {
        super("Susu", 2, 1);
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