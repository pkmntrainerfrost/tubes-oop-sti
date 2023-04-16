import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private List<GridObject> objects;
    private int length;
    private int width;

    public Room(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.objects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<GridObject> getObjects() {
        return objects;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void addObject(GridObject object) throws PositionOccupiedException {
        for (GridObject o : objects) {
            if (object.intersects(o)) {
                throw new PositionOccupiedException("Cannot add object to room, position is already occupied.");
            }
        }
        objects.add(object);
    }

    public void removeObject(GridObject object) {
        objects.remove(object);
    }

    public boolean contains(Point point) {
        return (point.getX() >= getPosition().getX() && point.getX() < getPosition().getX() + length
                && point.getY() >= getPosition().getY() && point.getY() < getPosition().getY() + width);
    }
}