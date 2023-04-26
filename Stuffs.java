public abstract class Stuffs extends GridObject implements Items {
    private String stuffName;
    private int stuffLength;
    private int stuffWidth;
    private int stuffPrice;
    private boolean buyable;

    // constructor
    public Stuffs(String stuffName, int stuffLength, int stuffWidth, int stuffPrice, Point point) {
        super(point, stuffLength, stuffWidth);
        this.stuffName = stuffName;
        this.stuffPrice = stuffPrice;
        this.buyable = true;
    }

    // override
    @Override
    public String getItemName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
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

    // getter

    public int getStuffLength() {
        return stuffLength;
    }

    public int getStuffWidth() {
        return stuffWidth;
    }

    public int getStuffPrice() {
        return stuffPrice;
    }

    // setter

    public void setStuffLength(int stuffLength) {
        this.stuffLength = stuffLength;
    }

    public void setStuffWidth(int stuffWidth) {
        this.stuffWidth = stuffWidth;
    }

    public void setStuffPrice(int stuffPrice) {
        this.stuffPrice = stuffPrice;
    }

    @Override
    public String getCategory() {
        // TODO Auto-generated method stub
        return "Stuffs";
    }
}