import java.util.*;

public class Recipe extends Food {
    
    private Map<InventoryItem,Integer> ingredients = new HashMap<>();

    public Recipe(String name, Map<InventoryItem,Integer> ingredients) {
        super(name, 0, false);
        this.ingredients = ingredients;
        this.setBuyable(false);
        this.setPrice(0);
    }

    public boolean isCookable(Map<Item,Int> Inventory) {
        
    }


}
