import java.util.ArrayList;
import java.util.List;

public class Foods implements Items {
    private List<Food> groupOfFood;
    private int foodsFullness;
    private String foodsName;
    private int foodsPrice = 0;
    private boolean buyable = false;

    public Foods(String foodsName, int foodsFullness) {
        this.foodsName = foodsName;
        this.foodsFullness = foodsFullness;
        this.groupOfFood = new ArrayList<Food>();
    }

    @Override
    public String getItemName() {
        return foodsName;
    }

    public void setItemName(String foodsName) {
        this.foodsName = foodsName;
    }

    public int getPrice() {
        return foodsPrice;
    }

    public void setPrice(int foodsPrice) {
        this.foodsPrice = foodsPrice;
    }

    public boolean getBuyable() {
        return buyable;
    }

    public void setBuyable(boolean buyable) {
        this.buyable = buyable;
    }

    public String getCategory() {
        return "Foods";
    }

    /* getter */
    public int getFoodFullness() {
        return foodsFullness;
    }
    
    public List<Food> getGroupOfFood() {
        return groupOfFood;
    }

    /* setter */
    public void setFoodFullness(int foodsFullness) {
        this.foodsFullness = foodsFullness;
    }
    
    public void setGroupOfFoodStuff(List<Food> groupOfFood) {
        this.groupOfFood = groupOfFood;
    }
}