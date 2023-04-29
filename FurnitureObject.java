public class FurnitureObject extends GridObject {
    
    private FurnitureType furniture;

    public FurnitureObject(Point point, FurnitureType furniture) {
        super(point,furniture.getFurnitureLength(),furniture.getFurnitureWidth());
    }

    public FurnitureType getFurniture(){
        return furniture;
    }

}
