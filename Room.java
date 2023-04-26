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

    // Method untuk mengedit room
    public void editRoom() {
        Scanner input = new Scanner(System.in);
        // Cek apakah sim yang sedang aktif saat ini berada di dalam room ini
        if (Sim.getCurrentSim().getCurrentRoom() == this) {
            System.out.println("Pilih opsi:");
            System.out.println("1. Pembelian barang baru");
            System.out.println("2. Pemindahan barang");
            
            int option = input.nextInt();
            switch (option) {
                // Case 1: Menambahkan item baru ke objectGrid
                case 1:
                    System.out.println("Masukkan nama barang:");
                    String itemName = input.next();
                    System.out.println("Masukkan harga barang:");
                    double itemPrice = input.nextDouble();
                    Items newItem = new Items(itemName, itemPrice);
                    objectGrid.addObject(newItem);
                    System.out.println("Barang " + itemName + " berhasil ditambahkan ke dalam ruangan " + name);
                    break;
                // Case 2: Memindahkan item ke room atau inventory sim
                case 2:
                    System.out.println("Masukkan nama barang yang ingin dipindahkan:");
                    String itemToMove = input.next();
                    GridObject item = objectGrid.findObjectByName(itemToMove);
                    if (item == null) {
                        System.out.println("Barang " + itemToMove + " tidak ditemukan di dalam ruangan " + name);
                    } else {
                        System.out.println("Pilih opsi:");
                        System.out.println("1. Pindahkan ke ruangan lain");
                        System.out.println("2. Pindahkan ke inventory Sim");
                        int moveOption = input.nextInt();
                        // Case 1: Memindahkan item ke room lain
                        if (moveOption == 1) {
                            System.out.println("Masukkan nama ruangan tujuan:");
                            String destinationRoomName = input.next();
                            Room destinationRoom = Sim.getCurrentSim().getHouse().findRoomByName(destinationRoomName);
                            if (destinationRoom == null) {
                                System.out.println("Ruangan " + destinationRoomName + " tidak ditemukan di dalam rumah.");
                            } else {
                                objectGrid.removeObject(item);
                                destinationRoom.getObjectGrid().addObject(item);
                                System.out.println("Barang " + itemToMove + " berhasil dipindahkan ke ruangan " + destinationRoomName);
                            }
                        // case 2: memindahkan item ke inventory sim
                        } else if (moveOption == 2) {
                            Sim.getCurrentSim().getInventory().addItem((Item)item);
                            objectGrid.removeObject(item);
                            System.out.println("Barang " + itemToMove + " berhasil dipindahkan ke inventory Sim");
                        } else {
                            System.out.println("Opsi yang dimasukkan tidak valid");
                        }
                    }
            }
        }
    }
}
