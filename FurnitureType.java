public class FurnitureType implements Item {

    public String furnitureName;
    public int furnitureLength;
    public int furnitureWidth;
    public int furniturePrice;
    public String furnitureAction;
    public boolean isBuyable = true;

    public FurnitureType(String furnitureName, int furnitureLength, int furnitureWidth, int furniturePrice, String furnitureAction) {
        this.furnitureName = furnitureName;
        this.furnitureLength = furnitureLength;
        this.furnitureWidth = furnitureWidth;
        this.furniturePrice = furniturePrice;
        this.furnitureAction = furnitureAction;
        this.isBuyable = true;
    }

    @Override
    public String getItemName() {
        return furnitureName;
    }
    public void setItemName(String name) {
        this.furnitureName = name;
    }

    public int getPrice() {
        return furniturePrice;
    }

    public void setPrice(int price) {
        this.furniturePrice = price;
    }

    public boolean getBuyable(){
        return isBuyable;
    }

    public void setBuyable(boolean isBuyable) {
        this.isBuyable = isBuyable;
    }

    public String getCategory() {
        return "Furniture";
    }

    /* getter */
    public int getFurnitureLength() {
        return this.furnitureLength;
    }    

    public int getFurnitureWidth () {
        return this.furnitureWidth;
    }

    public void setFurnitureLength(int newFurnitureLength){
        this.furnitureLength += newFurnitureLength;
    }

    public void setFurnitureWidth (int newFurnitureWidth){
        this.furnitureWidth += newFurnitureWidth;
    }

    public String getAction() {
        return furnitureAction;
    }

    public void setAction(String action) {
        this.furnitureAction = action;
    }

}