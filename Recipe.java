import java.util.*;

public class Recipe extends Food {
    
    private Map<InventoryItem, Integer> ingredients = new HashMap<>();

    public Recipe(String name, Map<InventoryItem, Integer> ingredients) {
        super(name, 0, 0);
        this.ingredients = ingredients;
        this.setBuyable(false);
        this.setPrice(0);
    }

    // Cek bisa dimasak apa ga
    public boolean isCookable(Inventory inventory) {
        for (InventoryItem ingredient : ingredients.keySet()) {
            if (!inventory.hasItem(ingredient.getName(), ingredients.get(ingredient))) {
                return false;
            }
        }
        return true;
    }

    // Masak
    public void cook(Inventory inventory) {
        if (isCookable(inventory)) {
            for (InventoryItem ingredient : ingredients.keySet()) {
                int quantityNeeded = ingredients.get(ingredient);
                inventory.removeItem(ingredient.getName(), quantityNeeded);
            }
            // inventory.addItem(){
    
        }
    }

}
