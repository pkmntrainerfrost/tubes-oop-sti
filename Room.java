import java.util.*;
import java.util.List;

public class Room extends GridObject {

    // Attribute objectGrid untuk menyimpan grid object di dalam room
    private Grid objectGrid;

    // Attribute name untuk menyimpan nama room
    private String name;

    // Attribute finished untuk menyimpan status selesai atau belumnya room
    private boolean finished;

    /*
     * private List<FurnitureObject> furnitureList;
     * private Map<String,RoomItem> items;
     */
    // Konstruktor dengan parameter point, name, dan finished
    public Room(Point point, String name, boolean finished) {
        // Memanggil konstruktor dari kelas induk
        super(point, 1, 1);
        // Membuat objectGrid baru
        objectGrid = new Grid(6, 6);
        // Mengisi atribut name dan finished
        this.name = name;
        this.finished = finished;
    }

    // Getter untuk nama ruangan
    public String getRoomName() {
        return this.name;
    }

    // Setter untuk attribute finished
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    // Getter untuk semua object pada objectGrid
    public List<GridObject> getFurnitureList() {
        return objectGrid.getObjects();
    }

    // display list items dalam room
    public void displayItemsInRoom() {
        System.out.println("Berikut merupakan items yang ada di ruang " + getRoomName() + ": ");
        for (GridObject furniture : objectGrid.getObjects()) {
            FurnitureType furnitureType = ((FurnitureObject) furniture).getFurniture();
            System.out.println(furnitureType.getItemName());
        }
    }

    public int getAvailableSpace() {
        int space = getHeight() * getLength();
        for (GridObject furniture : objectGrid.getObjects()) {
            space -= furniture.getHeight() * furniture.getLength();
        }
        return space;
    }

    public Grid getObjectGrid() {
        return this.objectGrid;
    }

    public GridObject findFurnitureName(String furnitureName) {
        for (GridObject furniture : getFurnitureList()) {
            if (((FurnitureObject) furniture).getFurniture().getItemName().equals(furnitureName)) {
                return ((GridObject) furniture);
            }
        }
        return null;
    }

}
