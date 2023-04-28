public class FoodStuffs implements Items {
    private int foodStuffPrice;
    private int foodStuffFullness;
    private String foodStuffName;

    // constructor
    public FoodStuffs(String foodStuffName, int foodStuffPrice, int foodStuffFullness) {
        this.foodStuffName = foodStuffName;
        this.foodStuffPrice = foodStuffPrice;
        this.foodStuffFullness = foodStuffFullness;
    }

    // override
    public String getItemName() {
        return foodStuffName;
    }

    public void setItemName(String foodStuffName) {
        this.foodStuffName = foodStuffName;
    }

    // getter
    public int getFoodStuffPrice() {
        return foodStuffPrice;
    }

    public int getFoodStuffFullness() {
        return foodStuffFullness;
    }

    public int getPrice() {
        return foodStuffPrice;
    }

    public boolean getBuyable() {
        return true;
    }

    // setter
    public void setFoodStuffPrice(int foodStuffPrice) {
        this.foodStuffPrice = foodStuffPrice;
    }

    public void setFoodStuffFullness(int foodStuffFullness) {
        this.foodStuffFullness = foodStuffFullness;
    }

    public void setPrice(int price) {
        this.foodStuffPrice = price;
    }

    public void setBuyable(boolean buyable) {

    }

    @Override
    public String getCategory() {
        // TODO Auto-generated method stub
        return "Food Stuffs";
    }
}