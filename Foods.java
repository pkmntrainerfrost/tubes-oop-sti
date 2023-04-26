import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Foods implements Items {
    private List<FoodStuffs> groupOfFoodStuff;
    private int foodFullness;
    private String foodName;
    private boolean buyable;
    private int price;

    public Foods(int foodFullness, String foodName) {
        this.foodFullness = foodFullness;
        this.foodName = foodName;
        this.groupOfFoodStuff = new ArrayList<FoodStuffs>();
        this.buyable = false;
        this.price = 0;
    }

    // override
    public String getItemName() {
        return foodName;
    }

    public void setItemName(String foodName) {
        this.foodName = foodName;
    }

    // getter
    public int getFoodFullness() {
        return foodFullness;
    }
    
    public List<FoodStuffs> getGroupOfFoodStuff() {
        return groupOfFoodStuff;
    }

    // setter
    public void setFoodFullness(int foodFullness) {
        this.foodFullness = foodFullness;
    }
    
    public void setGroupOfFoodStuff(List<FoodStuffs> groupOfFoodStuff) {
        this.groupOfFoodStuff = groupOfFoodStuff;
    }

    @Override
    public String getCategory() {
        // TODO Auto-generated method stub
        return "Foods";
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = 0;
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

    public void setFullness(int fullness) {
        this.foodFullness = fullness;
    }
}