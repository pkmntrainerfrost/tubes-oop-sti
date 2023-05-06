public class FurnitureObject extends GridObject {

    /* Decorator */

    private FurnitureType furniture;

    public FurnitureObject(Point point, FurnitureType furniture) {
        super(point,furniture.getFurnitureLength(),furniture.getFurnitureWidth());
        this.furniture = furniture;
    }

    public FurnitureType getFurniture(){
        return furniture;
    }

}
