public class InstallableItem implements Items {
    private String itemName;
    private String category;
    private int weight;
    private int price;
    private boolean buyable;
    private boolean isInstalled;

    public InstallableItem(String itemName, String category, int weight, int price, boolean buyable, boolean isInstalled) {
        this.itemName = itemName;
        this.category = category;
        this.weight = weight;
        this.price = price;
        this.buyable = buyable;
        this.isInstalled = isInstalled;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getBuyable() {
        return buyable;
    }

    public void setBuyable(boolean buyable) {
        this.buyable = buyable;
    }

    public boolean isInstalled() {
        return isInstalled;
    }

    public void setInstalled(boolean installed) {
        isInstalled = installed;
    }

    public boolean canInstall(Room room) {
        return false;
    }

    public void install(Room room) {
    }
}
