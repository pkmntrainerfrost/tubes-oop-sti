import java.util.*;

public class Recipe extends Food implements Item {
    
    private Map<Item,Int> ingredients = new HashMap<>();

    public Recipe(String name, Map<Item,Int> Ingredients) {
        super(name);
        this.ingredients = ingredients;
        this.setBuyable(false);
        this.setPrice(0);
    }

    public boolean isCookable(Map<Item,Int> Inventory) {
        
    }


}
