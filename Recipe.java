import java.util.*;

public class Recipe extends Food {
    
    private Map<InventoryItem,Integer> ingredients = new HashMap<>();

    public Recipe(String name, Map<InventoryItem,Integer> Ingredients) {
        super(name, );
        this.ingredients = ingredients;
        this.setBuyable(false);
        this.setPrice(0);
    }

    public boolean isCookable(Map<Item,Int> Inventory) {
        
    }


}
