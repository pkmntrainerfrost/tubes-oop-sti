public interface Items {
    public String getItemName();
    public void setItemName(String itemName);
    public boolean getBuyable();
    public void setBuyable(boolean buyable);
    public int getPrice();
    public void setPrice(int itemPrice);
    public String getCategory();
    public static Items[] values() {
        return null;
    }
}