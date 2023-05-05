public class InventoryItem {
    private String name;
    private String category;
    private int quantity;
    private Item item;

    public InventoryItem(Item item, int quantity) {
        this.item = item;
        this.name = item.getItemName();
        this.category = item.getCategory();
        this.quantity = quantity;
    }

    public Item getItems(){
        return item;
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

