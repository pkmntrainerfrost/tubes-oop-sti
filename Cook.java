import java.util.*;

public class Cook extends SimActiveAction {
    
    private Recipe recipe;

    /*
    public Cook(Sim sim, Food itemMakanan){
        super(sim);
        this.itemMakanan = itemMakanan;
        setDuration((int)1.5 * 1); //SEMENTARA
        listDimasak.add(itemMakanan.getItemName());
    }
    */

    public void begin(Sim sim) {
        boolean validpos = true;
        if (sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition()) == null) {
            validpos = false;
        } else {
            FurnitureObject furniture = (FurnitureObject) sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition());
            if (!(furniture.getFurniture().getAction().equals("Cook"))) {
                validpos = false;
            }
        }
        if (!validpos) {
            System.out.println("You are not on the correct object!");
            setCancelled(true);
        } else {
        System.out.print("input recipe's name: ");
        Scanner scan = new Scanner(System.in);
        String recipeName = scan.next();

        CommandLine cli = new CommandLine();

        while (!cli.validateInputString(recipeName)){
            System.out.print("input recipe's name: ");
            recipeName = scan.next();
        }
        
        if(recipe.getItemName().equals(recipeName)){
            if (recipe.isCookable(sim.getInventory())) {
                int duration = ((int)1.5 * recipe.getFullness());
                this.setDuration(duration);
                System.out.println("recipe successfully cooked!");
            } else {
                System.out.println("ingredients doesn't exist!");
                this.setCancelled(true);
            }
        } else {
            this.setCancelled(true);
        }
        }
    }

    public void end(Sim sim) {
        sim.setMood(sim.getMood() + 10);
        recipe.cook(sim.getInventory());
        sim.getInventory().addItem(recipe, 1);
        /*
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Kompor Gas") || getSim().getCurrentRoom().getItemListInRoom().contains("Kompor Listrik") ){
            for (int i = 0; i < listDimasak.size(); i++){
                getSim().setMood(getSim().getMood()+10);
            }
        }
        listDimasak.remove(itemMakanan.getItemName());
        */

       /*
       public void cook (String mealName) {
        System.out.println(this.fullName + " sedang memasak " + mealName);
        this.status = "cooking";
        FoodCooked meal = new FoodCooked(mealName);
        ArrayList<FoodIngredients> ingredients = meal.getIngredientsList();
        currentWorld.getWorldClock().wait((int) (1.5*meal.getSatiation()));
        for (Item ingredient : ingredients) {
            for (Item item : inventory.getInventory().keySet()) {
                if (item.getClass().getName().equals("FoodIngredients")) {
                    if (item.equals(ingredient)) {
                        inventory.deleteInventory(item);
                        ingredients.remove(ingredient);
                    }
                }
            }
        };
        
        if (ingredients.isEmpty()) {
            inventory.addInventory(meal);
            System.out.println(meal.getName() + " ditambahkan ke inventory!");
            currentWorld.getWorldClock().updateTime((int) (1.5*meal.getSatiation())); 
        } else {
            System.out.println(meal.getName() + " tidak jadi karena bahan kurang!");
        }
    }

       */
    }
}

class RecipeDoesntExistException extends Exception {
    public RecipeDoesntExistException(String messageString) {
        super(messageString);
    }
}