public abstract class GridObject {

    private Point point;

    private int length;
    private int height;

    public GridObject(Point point, int length, int height) {
        this.point = point;
        this.length = length;
        this.height = height;
    }

}