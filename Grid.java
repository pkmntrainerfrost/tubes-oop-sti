import java.util.*;

public class Grid {
    
    private List<GridObject> objects;
    private int maxX;
    private int maxY;

    public Grid(int maxX, int maxY) {
        objects = new ArrayList<>();
        this.maxX = maxX;
        this.maxY = maxY;
    }

    //ditambahin trista
    public void setGridX(int num){
        this.maxX += num;
    }

    public void setGridY(int num){
        this.maxY += num;
    }
    //sampe sini

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
        if (object.getMaximumX() > maxX || object.getMaximumY() > maxY || object.getMinimumX() < 0 || object.getMinimumY() < 0) { //deleted =
            throw new PositionOutOfBoundsException("Out of Bounds");
        } else {
            for (GridObject otherObject : objects) {
                if (object.overlap(otherObject)) {
                    throw new PositionOccupiedException("Object Overlaps Other Object");
                }
            }
        }
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