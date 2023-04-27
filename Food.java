public abstract class Food implements Items {
    private String foodName;
    private int foodFullness;
    private int foodPrice;
    private boolean buyable = true;
    
    public Food(String foodName, int foodFullness, int foodPrice) {
        this.foodName = foodName;
        this.foodFullness = foodFullness;
        this.foodPrice = foodPrice;
    }
    
    @Override
    public String getItemName() {
        return foodName;
    }

    public void setItemName(String foodName) {
        this.foodName = foodName;
    }

    public int getPrice() {
        return foodPrice;
    }

    public void setPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public boolean getBuyable() {
        return buyable;
    }

    public void setBuyable(boolean buyable) {
        this.buyable = buyable;
    }

    public int getFullness() {
        return foodFullness;
    }

    public void setFullness(int foodFullness) {
        this.foodFullness = foodFullness;
    }

    public String getCategory() {
        return "Food";
    }
}