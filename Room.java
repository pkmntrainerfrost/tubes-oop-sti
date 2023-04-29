import java.util.*;

import java.util.ArrayList;

import java.util.List;

public class Room extends GridObject {
    
    // Attribute objectGrid untuk menyimpan grid object di dalam room
    private Grid objectGrid;

    // Attribute name untuk menyimpan nama room
    private String name;

    // Attribute finished untuk menyimpan status selesai atau belumnya room
    private boolean finished;

    private List<Stuffs> stuffList;

    // Konstruktor dengan parameter point, name, dan finished
    public Room(Point point, String name, boolean finished) {
        // Memanggil konstruktor dari kelas induk
        super(point, 6, 6);
        // Membuat objectGrid baru
        objectGrid = new Grid(6+point.getX(), 6+point.getY(), point.getX(), point.getY());
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
    public List<GridObject> getObjects() {
        return objectGrid.getObjects();
    }

    // Getter untuk list items dalam room
    public List<Stuffs> getItemListInRoom(){
        return this.stuffList;
    }

    // display list items dalam room
    public void displayItemsInRoom(){
        List<Stuffs> listItems;
        listItems = getItemListInRoom();

        for (Stuffs stuff : listItems) {
            System.out.println("Berikut merupakan items yang ada di ruang " + getRoomName() + ": ");
            System.out.println(stuff.getItemName());
        }
    }

// belom selesai
// gini gasi gatau si aing kalo salah ganti lagi aja
// itu gatau bener instanceof object atau kaga
    public int getAvailableSpace(){
        int space = getHeight()*getLength();
        for(Stuffs item: stuffList){
            if(item instanceof Items){
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
            System.out.println("Sim berhasil berpindah ke " + newRoom.getRoomName());
        } else {
            System.out.println("Sim tidak berada di dalam rumah ini!");
        }
    }

    public Stuffs getItem(String itemName) {
        return null;
    }

    public int getItemQuantity(String itemName) {
        return 0;
    }

    public Items removeItem(String itemName, int i) {
        return null;
    }

    public void addItem(Items itemToMove, int i) {
    }

    public void buyItem(Stuffs buyableItem) throws ItemNotInInventoryException {
        if (!buyableItem.getBuyable()) {
            throw new ItemNotInInventoryException("Item " + buyableItem + " tidak dapat dipasang di ruangan " + getRoomName() + ".");
        }
        buyableItem.getBuyable();
        
    }
    
}