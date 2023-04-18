public class Stuffs extends GridObject implements Items {
    private String stuffName;
    private int stuffLength;
    private int stuffWidth;
    private int stuffPrice;
    private Action action;

    // constructor
    public Stuffs(String stuffName, int stuffLength, int stuffWidth, int stuffPrice, Action action, Point point) {
        super(point, stuffLength, stuffWidth);
        this.stuffName = stuffName;
        this.stuffLength = stuffLength;
        this.stuffWidth = stuffWidth;
        this.stuffPrice = stuffPrice;
        this.action = action;
    }

    // override
    public String getItemName() {
        return stuffName;
    }

    public void setItemName(String stuffName) {
        this.stuffName = stuffName;
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

    public Action getAction() {
        return action;
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

    public void setAction(Action action) {
        this.action = action;
    }
}