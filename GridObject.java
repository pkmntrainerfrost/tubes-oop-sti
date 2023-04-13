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
        return point.getX() + length - 1;
    }

    public int getMaximumY() {
        return point.getY() + height - 1;
    }

    public int getMinimumX() {
        return point.getX();
    }

    public int getMinimumY() {
        return point.getY();
    }

    public boolean overlap(GridObject object) {
        return (this.getMinimumX() >= object.getMinimumX() && this.getMinimumX() <= object.getMaximumX()) || (this.getMinimumY() >= object.getMinimumY() && this.getMinimumY() <= this.getMaximumY());
    }

}