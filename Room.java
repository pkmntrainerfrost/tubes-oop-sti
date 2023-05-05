import java.util.*;
import java.util.List;

public class Room extends GridObject {
    
    // Attribute objectGrid untuk menyimpan grid object di dalam room
    private Grid objectGrid;

    // Attribute name untuk menyimpan nama room
    private String name;

    // Attribute finished untuk menyimpan status selesai atau belumnya room
    private boolean finished;

    private List<FurnitureObject> furnitureList;
    private Map<String,RoomItem> items; 
    // Konstruktor dengan parameter point, name, dan finished
    public Room(Point point, String name, boolean finished) {
        // Memanggil konstruktor dari kelas induk
        super(point, 1, 1);
        // Membuat objectGrid baru
        objectGrid = new Grid(6,6);
        // Mengisi atribut name dan finished
        this.name = name;
        this.finished = finished;
        items = new HashMap<>();
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
    public List<GridObject> getObjects() {
        return objectGrid.getObjects();
    }

    // Getter untuk list items dalam room
    public List<FurnitureObject> getItemListInRoom(){
        return this.furnitureList;
    }

    // display list items dalam room
    public void displayItemsInRoom(){
        List<FurnitureObject> listItems;
        listItems = getItemListInRoom();

        for (FurnitureObject furniture : listItems) {
            System.out.println("Berikut merupakan items yang ada di ruang " + getRoomName() + ": ");
            System.out.println(furniture.getFurniture().getItemName());
        }
    }

    public int getAvailableSpace(){
        int space = getHeight()*getLength();
        for(FurnitureObject item: furnitureList){
            if(item instanceof Item){
                space -= 1;
            } else if(item instanceof GridObject){
                GridObject object = (GridObject) item;
                space -= object.getHeight() * object.getLength();
            }
        }
        return space;
    }

    public Grid getObjectGrid(){
        return this.objectGrid;
    }

    // Method untuk memindahkan sim ke room baru
    public void moveRoom(Sim sim, Room newRoom) {
        // Cek apakah sim saat ini berada di dalam room ini
        if (sim.getCurrentRoom() == this) {
            // Memindahkan sim ke room baru
            sim.setCurrentRoom(newRoom);
            sim.setCurrentPosition(newRoom.getPoint());
            System.out.println("Sim berhasil berpindah ke " + newRoom.getRoomName());
        } else {
            System.out.println("Sim tidak berada di dalam rumah ini!");
        }
    }

    public FurnitureObject getItem(String itemName) {
        return null;
    }

    public String findFurnitureName(String furnitureName) {
        for (FurnitureObject furniture : furnitureList) {
            if (furniture.getFurniture().getItemName().equals(furnitureName)) {
                return furniture.getFurniture().getItemName();
            }
        }
        return null;
    }

    public int getItemQuantity(String itemName) {
        return 0;
    }
    

    //menambah objek ke room
    public void addItem(Item item, int quantity) {
        if (items.containsKey(item.getItemName())) {
            RoomItem currentItem = items.get(item.getItemName());
            currentItem.setQuantity(currentItem.getQuantity() + quantity);
        } else {
            RoomItem newItem = new RoomItem(item, quantity);
            items.put(item.getItemName(), newItem);
        }
        clearZeroQuantityItems();
    }

    // Menghapus objek dari Room
    public void removeItem(String itemName, int quantity) {
        if (items.containsKey(itemName)) {
            RoomItem currentItem = items.get(itemName);
            if (currentItem.getQuantity() > quantity) {
                currentItem.setQuantity(currentItem.getQuantity() - quantity);
            } else {
                items.remove(itemName);
            }
        }
        clearZeroQuantityItems();
    }

    // Menghapus objek dari inventory jika jumlahnya 0
    public void clearZeroQuantityItems() {
        items.entrySet().removeIf(entry -> entry.getValue().getQuantity() == 0);
    }

    public void buyItem(InventoryItem buyableItem) throws ItemNotInInventoryException {
        if (!buyableItem.getFurniture().getBuyable()) {
            throw new ItemNotInInventoryException("Item " + buyableItem + " tidak dapat dipasang di ruangan " + getRoomName() + ".");
        }
        buyableItem.getFurniture().getBuyable();
        
    }
}


