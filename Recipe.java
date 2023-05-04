import java.util.*;

public class Recipe extends Food {
    
    private Map<String, Integer> ingredients = new HashMap<>();

    public Recipe(String name, int fullness, Map<String, Integer> ingredients) {
        super(name, 0, fullness);
        this.ingredients = ingredients;
        this.setBuyable(false);
    }

    // Cek bisa dimasak apa ga
    public boolean isCookable(Inventory inventory) {
        for (String ingredient : ingredients.keySet()) {
            if (!inventory.hasItem(ingredient.getName(), ingredients.get(ingredient))) {
                return false;
            }
        }
        return true;
    }

    // Masak
    public void cook(Inventory inventory) {
        if (isCookable(inventory)) {
            for (String ingredient : ingredients.keySet()) {
                int quantityNeeded = ingredients.get(ingredient);
                inventory.removeItem(ingredient.getName(), quantityNeeded);
            }
            // inventory.addItem(){
    
        }
    }

}
