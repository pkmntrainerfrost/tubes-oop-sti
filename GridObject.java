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
        /*
        boolean flag = true;
        if (this.getMaximumY() <= object.getMinimumY() || this.getMinimumY() >= object.getMaximumY()){
            flag = false;
        }
        if (this.getMaximumX() <= object.getMinimumX() || this.getMinimumX() >= object.getMaximumX()){
            flag = false;
        }   
        */
       /*
       System.out.println("---");
       System.out.println(length);
       System.out.println(height);
       System.out.println(getMaximumX());
       System.out.println(getMinimumX());
       System.out.println(getMaximumY());
       System.out.println(getMinimumY());
       System.out.println("---");
       System.out.println(object.getLength());
       System.out.println(object.getHeight());
       System.out.println(object.getMaximumX());
       System.out.println(object.getMinimumX());
       System.out.println(object.getMaximumY());
       System.out.println(object.getMinimumY());
       */

        return !((this.getMaximumY() <= object.getMinimumY() || this.getMinimumY() >= object.getMaximumY()) ||  (this.getMaximumX() <= object.getMinimumX() || this.getMinimumX() >= object.getMaximumX()));
    
    }

    public boolean overlap(Point point) {
        return (this.getMinimumX() >= point.getX() && this.getMinimumX() <= point.getX()) && (this.getMinimumY() >= point.getY() && this.getMinimumY() <= point.getY());
    }


}