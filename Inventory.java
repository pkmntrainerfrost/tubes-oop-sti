import java.util.*;

public class Inventory {
    private Map<String, InventoryItem> items; // Map untuk menyimpan objek dalam inventory

    public Inventory() {
        items = new HashMap<>();
    }

    // Menambahkan objek ke inventory
    public void addItem(String itemName, String category, int quantity) {
        if (items.containsKey(itemName)) {
            InventoryItem currentItem = items.get(itemName);
            currentItem.setQuantity(currentItem.getQuantity() + quantity);
        } else {
            InventoryItem newItem = new InventoryItem(itemName, category, quantity);
            items.put(itemName, newItem);
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