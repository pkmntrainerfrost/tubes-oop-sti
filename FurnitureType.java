public class FurnitureType implements Item {
    
    public String name;
    public int length;
    public int height;
    public int price;
    public Action action;

    public Furniture(String name, int length, int height, int price, Action action) {
        this.name = name;
        this.length = length;
        this.height = height;
        this.price = price;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLength() {
        return this.length;
    }    

    public int getHeight() {
        return this.height;
    }    

    public void setLength(int num){
        this.length += num;
    }

    public void getWidth(int num){
        this.height += num;
    }

}
