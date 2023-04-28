public class FurnitureType implements Items {
    
    public String name;
    public int length;
    public int height;
    public int price;
    public Action action;
    public boolean isBuyable = true;

    public FurnitureType(String name, int length, int height, int price, Action action) {
        this.name = name;
        this.length = length;
        this.height = height;
        this.price = price;
        this.action = action;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public void setItemName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean getBuyable() {
        return isBuyable;
    }

    @Override
    public void setBuyable(boolean isBuyable) {
        this.isBuyable = isBuyable;
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }

    public int getLength() {
        return this.length;
    }    

    public int getHeight() {
        return this.height;
    }    

    public void setLength(int num){
        this.length += num;
    }

    public void setHeight(int num){
        this.height += num;
    }
}