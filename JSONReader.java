import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/* ALLAH tolong ampuni hamba-Mu; teman-teman tolong maafkan aku */
/* kode dibawah jorok banget COKKKKKKKKKKKKK */

public class JSONReader {

    private static final Gson gson = new Gson();

    public static HashMap<String, Job> readJobs() {
        try (FileReader reader = new FileReader(Paths.get("common/jobs.json").toFile())) {
            JsonObject jobObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray jobArray = jobObject.getAsJsonArray("jobs");
            HashMap<String, Job> jobs = new HashMap<>();
            for (JsonElement jobElement : jobArray) {
                Job job = gson.fromJson(jobElement, Job.class);
                jobs.put(job.getName(),job);
            }
            return jobs;
        } catch (IOException e) {
            return null;
        }
    }

    public static HashMap<String, Item> readItems() {
        HashMap<String, Item> itemMap = new HashMap<>();
        readIngredients(itemMap);
        readRecipes(itemMap);
        readFurnitureTypes(itemMap);
        return itemMap;
    }

    public static void readIngredients(HashMap<String, Item> itemMap) {
        try (FileReader reader = new FileReader(Paths.get("common/ingredients.json").toFile())) {
            JsonObject ingredientObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray ingredientArray = ingredientObject.getAsJsonArray("ingredients");
            for (JsonElement ingredientElement : ingredientArray) {
                JsonObject ingredientJSON = ingredientElement.getAsJsonObject();
                Ingredient ingredient = new Ingredient(ingredientJSON.get("name").getAsString(), ingredientJSON.get("fullness").getAsInt(), ingredientJSON.get("price").getAsInt());
                itemMap.put(ingredient.getItemName(),ingredient);
            }
        } catch (IOException e) {
            
        }
    }

    public static void readRecipes(HashMap<String, Item> itemMap) {
        try (FileReader reader = new FileReader(Paths.get("common/recipes.json").toFile())) {
            JsonObject recipeObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray recipeArray = recipeObject.getAsJsonArray("recipes");
            for (JsonElement recipeElement : recipeArray) {
                JsonObject recipeJSON = recipeElement.getAsJsonObject();
                JsonArray ingredientArray = recipeJSON.getAsJsonArray("ingredients");
                HashMap<String, Integer> ingredientsMap = new HashMap<>();
                for (JsonElement ingredientElement : ingredientArray) {
                    String ingredientName = ingredientElement.getAsJsonObject().get("name").getAsString();
                    int quantity = ingredientElement.getAsJsonObject().get("quantity").getAsInt();
                    ingredientsMap.put(ingredientName, quantity);
                }
                Recipe recipe = new Recipe(recipeJSON.get("name").getAsString(), recipeJSON.get("fullness").getAsInt(), ingredientsMap);
                itemMap.put(recipe.getItemName(),recipe);
            }
        } catch (IOException e) {
            
        }
    }

    public static void readFurnitureTypes(HashMap<String, Item> itemMap) {
        try (FileReader reader = new FileReader(Paths.get("common/furnituretypes.json").toFile())) {
            JsonObject furnitureTypeObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray furnitureTypeArray = furnitureTypeObject.getAsJsonArray("furniture");
            for (JsonElement furnitureTypeElement : furnitureTypeArray) {
                JsonObject furnitureTypeJSON = furnitureTypeElement.getAsJsonObject();
                FurnitureType furnitureType = new FurnitureType(furnitureTypeJSON.get("name").getAsString(), furnitureTypeJSON.get("length").getAsInt(), furnitureTypeJSON.get("height").getAsInt(),furnitureTypeJSON.get("price").getAsInt(),furnitureTypeJSON.get("action").getAsString());
                itemMap.put(furnitureType.getItemName(),furnitureType);
            }
        } catch (IOException e) {
            
        }
    }

}