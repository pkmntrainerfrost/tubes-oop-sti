// ini gajadi diganti pakai furnitureType dan furnitureObject aja
public abstract class Stuffs extends GridObject implements Items {
    private String stuffName;
    private int stuffLength;
    private int stuffWidth;
    private int stuffPrice;
    private boolean buyable = true;

    // constructor
    public Stuffs(String stuffName, int stuffLength, int stuffWidth, int stuffPrice, Point point) {
        super(point, stuffLength, stuffWidth);
        this.stuffName = stuffName;
        this.stuffPrice = stuffPrice;
    }

    @Override
    public String getItemName() {
        return stuffName;
    }

    public void setItemName(String stuffName) {
        this.stuffName = stuffName;
    }

    public int getPrice() {
        return stuffPrice;
    }

    public void setPrice(int stuffPrice) {
        this.stuffPrice = stuffPrice;
    }

    public boolean getBuyable() {
        return buyable;
    }

    public void setBuyable(boolean buyable) {
        this.buyable = buyable;
    }

    public String getCategory() {
        return "Stuffs";
    }

    /* getter */
    public int getStuffLength() {
        return stuffLength;
    }

    public int getStuffWidth() {
        return stuffWidth;
    }

    public int getStuffPrice() {
        return stuffPrice;
    }

    /* setter */
    public void setStuffLength(int stuffLength) {
        this.stuffLength = stuffLength;
    }

    public void setStuffWidth(int stuffWidth) {
        this.stuffWidth = stuffWidth;
    }

    public void setStuffPrice(int stuffPrice) {
        this.stuffPrice = stuffPrice;
    }
}