public abstract class GridObject {

    private Point point;

    private int length;
    private int width;

    public GridObject(Point point, int length, int width) {
        this.point = point;
        this.length = length;
        this.width = width;
    }

    public Point getPoint() {
        return point;
    }

    public int getMaximumX() {
        return point.getX() + length; //deleted -1
    }

    public int getMaximumY() {
        return point.getY() + width; //deleted -1
    }

    public int getMinimumX() {
        return point.getX();
    }

    public int getMinimumY() {
        return point.getY();
    }

//ditambahin trista
    public int getLength() {
        return this.length;
    }    

    public int getWidth() {
        return this.width;
    }    


    public void setLength(int num){
        this.length += num;
    }

    public void setWidth(int num){
        this.width += num;
    }
//sampe sini
    public boolean overlap(GridObject object) {
        return (this.getMinimumX() >= object.getMinimumX() && this.getMinimumX() <= object.getMaximumX()) || (this.getMinimumY() >= object.getMinimumY() && this.getMinimumY() <= this.getMaximumY());
    }

}