public abstract class Food implements Items {

    private String name;
    private boolean buyable;
    private int price;
    private int fullness;
    
    public Food(String name, int fullness, int price) {
        this.name = name;
        this.fullness = fullness;
        this.price = price;
        this.buyable = true;
    }
    
    @Override
    public String getItemName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getBuyable() {
        return buyable;
    }

    public void setBuyable(boolean buyable) {
        this.buyable = buyable;
    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    @Override
    public String getCategory() {
        // TODO Auto-generated method stub
        return "Food";
    }
}