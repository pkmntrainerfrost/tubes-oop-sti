public class RoomItem {
    private String name;
    private String category;
    private int quantity;
    private Items item;

    public RoomItem(Items item, int quantity) {
        this.item = item;
        this.name = item.getItemName();
        this.category = item.getCategory();
        this.quantity = quantity;
    }

    public Items getItems(){
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

