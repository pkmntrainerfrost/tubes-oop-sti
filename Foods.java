import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Foods implements Items {
    private List<FoodStuffs> groupOfFoodStuff;
    private int foodFullness;
    private String foodName;

    public Foods(int foodFullness, String foodName) {
        this.foodFullness = foodFullness;
        this.foodName = foodName;
        this.groupOfFoodStuff = new ArrayList<FoodStuffs>();
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
}