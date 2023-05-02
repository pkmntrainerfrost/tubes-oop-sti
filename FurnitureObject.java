public class FurnitureObject extends GridObject {

    /* Decorator */

    private FurnitureType furniture;

    public FurnitureObject(Point point, FurnitureType furniture) {
        super(point,furniture.getFurnitureLength(),furniture.getFurnitureWidth());
    }

    public FurnitureType getFurniture(){
        return furniture;
    }

}
