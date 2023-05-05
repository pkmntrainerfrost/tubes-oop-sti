import java.util.*;

public class Grid {
    
    private List<GridObject> objects;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;

    public Grid(int maxX, int maxY, int minX, int minY) {
        objects = new ArrayList<>();
        this.maxX = maxX;
        this.maxY = maxY;
        this.minX = 0 - minX;
        this.minY = 0 - minY;
    }

    public Grid(int maxX, int maxY) {
        objects = new ArrayList<>();
        this.maxX = maxX;
        this.maxY = maxY;
        this.minX = 0;
        this.minY = 0;
    }

    public void addMaxX(int num) { 
        this.maxX += num;
    }

    public void addMaxY(int num) {
        this.maxY += num;
    }

    public void addMinX(int num) {
        this.minX -= num;
    }

    public void addMinY(int num) {
        this.minY -= num;
    }

    public void addObject(GridObject object) throws PositionOccupiedException, PositionOutOfBoundsException {
        try {
            validPosition(object);
            objects.add(object);
        } catch (PositionOccupiedException e) {
            throw e;
        } catch (PositionOutOfBoundsException e) {
            throw e;
        }
    }

    public void validPosition(GridObject object) throws PositionOccupiedException, PositionOutOfBoundsException {
        if (object.getMaximumX() > maxX || object.getMaximumY() > maxY || object.getMinimumX() < minX || object.getMinimumY() < minY) { //deleted =
            throw new PositionOutOfBoundsException("Out of Bounds");
        } else {
            for (GridObject otherObject : objects) {
                if (object.overlap(otherObject)) {
                    throw new PositionOccupiedException("Object Overlaps Other Object");
                }
            }
        }
    }

    public GridObject objectOnPosition(Point point) {
        for (GridObject object : objects) {
            if (object.overlap(point)) {
                return object;
            }
        }
        return null;
    }

    public List<GridObject> getObjects() {
        return objects;
    }

}

class PositionOccupiedException extends Exception {
    public PositionOccupiedException(String errorMessage) {
        super(errorMessage);
    }
}

class PositionOutOfBoundsException extends Exception {
    public PositionOutOfBoundsException(String errorMessage) {
        super(errorMessage);
    }
}