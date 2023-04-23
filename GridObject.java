public abstract class GridObject {

    private Point point;

    private int length;
    private int height;

    public GridObject(Point point, int length, int height) {
        this.point = point;
        this.length = length;
        this.height = height;
    }

    public Point getPoint() {
        return point;
    }

    public int getMaximumX() {
        return point.getX() + length; //deleted -1
    }

    public int getMaximumY() {
        return point.getY() + height; //deleted -1
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

    public int getHeight() {
        return this.height;
    }    

    public void setLength(int num){
        this.length += num;
    }

    public void getWidth(int num){
        this.height += num;
    }
//sampe sini

//halo izin ganti source nya dari sini 
//https://www.baeldung.com/java-check-if-two-rectangles-overlap

    public boolean overlap(GridObject object) {
        // return (this.getMinimumX() >= object.getMinimumX() && this.getMinimumX() <= object.getMaximumX()) || (this.getMinimumY() >= object.getMinimumY() && this.getMinimumY() <= this.getMaximumY());
        boolean flag = true;
        if (this.getMaximumY() <= object.getMinimumY() || this.getMinimumY() >= object.getMaximumY()){
            flag = false;
        }
        if (this.getMaximumX() <= object.getMinimumX() || this.getMinimumX() >= object.getMaximumX()){
            flag = false;
        }
        return flag;
    }
}