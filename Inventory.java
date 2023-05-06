import java.util.*;

public class Inventory {

    private Map<String,InventoryItem> items; 
    private int price;

    public Inventory() {
        items = new HashMap<>();
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public static Inventory[] getItem() {
		return null;
    }
    public int getPrice(){
        return price;
    }

    public ArrayList<InventoryItem> getArrayInventoryItem() {
        ArrayList<InventoryItem> arrayInvItem = new ArrayList<>();
        items.forEach((String, InventoryItem) -> {
            arrayInvItem.add(InventoryItem);
        });

        return arrayInvItem;
    }

    public Map<String,InventoryItem> getItems() {
        return items;
    }

    Scanner sc = new Scanner(System.in);

    // Menambahkan objek ke inventory
    public void addItem(Item item, int quantity) {
        if (items.containsKey(item.getItemName())) {
            InventoryItem currentItem = items.get(item.getItemName());
            currentItem.setQuantity(currentItem.getQuantity() + quantity);
        } else {
            InventoryItem newItem = new InventoryItem(item, quantity);
            items.put(item.getItemName(), newItem);
        }
        clearZeroQuantityItems();
    }

    // Menghapus objek dari inventory
    public void removeItem(String itemName, int quantity) {
        if (items.containsKey(itemName)) {
            InventoryItem currentItem = items.get(itemName);
            if (currentItem.getQuantity() > quantity) {
                currentItem.setQuantity(currentItem.getQuantity() - quantity);
            } else {
                items.remove(itemName);
            }
        }
        clearZeroQuantityItems();
    }

    // Mendapatkan jumlah objek dalam inventory
    public int getItemQuantity(String itemName) {
        if (items.containsKey(itemName)) {
            return items.get(itemName).getQuantity();
        } else {
            return 0;
        }
    }

    public boolean hasItem(String itemName, int quantity) {
        if (items.containsKey(itemName)) {
            int currentQuantity = items.get(itemName).getQuantity();
            return currentQuantity >= quantity;
        } else {
            return false;
        }
    }

    // Menjual barang di inventory 
    public void sellItem(String itemName, int quantity, int pricePerItem, Sim sim) throws SimMiskinException {
        if (items.containsKey(itemName)) {
            InventoryItem currentItem = items.get(itemName);
            int currentQuantity = currentItem.getQuantity();
            if (currentQuantity >= quantity) {
                int totalPrice = pricePerItem * quantity;
                System.out.println("Total Price: " + totalPrice);
                System.out.println("Proceed to sell? [Y/N]");
                String choice = sc.nextLine();
                if (choice.equals("Y")){
                    if (sim.getUang() >= totalPrice){
                        sim.setUang(totalPrice);
                        removeItem(itemName, quantity);
                        System.out.println(quantity + " " + itemName + " has been sold");
                    }
                    else{
                        throw new SimMiskinException("You dont have enough money!");
                    }
                }
            } else {
                System.out.println("There is not enough " + itemName + " in your inventory");
            }
        } else {
            System.out.println("There is no " + itemName + " in your inventory");
        }
    }

    // Menghapus objek dari inventory jika jumlahnya 0
    public void clearZeroQuantityItems() {
        items.entrySet().removeIf(entry -> entry.getValue().getQuantity() == 0);
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        System.out.println("====================================");
        System.out.println("Nama Barang | Kategori | Jumlah");
        System.out.println("------------------------------------");
        for (InventoryItem item : items.values()) {
            System.out.println(item.getName() + " | " + item.getCategory() + " | " + item.getQuantity());
        }
        System.out.println("====================================");
    }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String messageString) {
        super(messageString);
    }
}




/*
public class Inventory {

    private Map<Items,Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(Items item, int quantity) throws InvalidQuantityException {
        if (items.containsKey(item)) {
            //
        } else {
            items.put(item, quantity);
        }
        clearZeroQuantityItems();
    }

    public void removeItem(String itemName, int quantity) throws InvalidQuantityException {
        if (items.currentItemcontainsKey(itemName)) {
            if ( > quantity) {
                //
            } else if () {
                items.remove(itemName);
            }
        }
        clearZeroQuantityItems();
    }

    public Object getItem(String itemName) {
        return null;
    }

}
*/
/*

    public Object getCurrentRoom() {
        return null;
    }
}
    
    // Inner class untuk merepresentasikan item dalam inventory
    private static class InventoryItem {
        private String name;
        private String category;
        private int quantity;

        public InventoryItem(String name, String category, int quantity) {
            this.name = name;
            this.category = category;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}

}


*/