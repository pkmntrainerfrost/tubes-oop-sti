import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Room extends GridObject {

    // Atribut yang digunakan untuk menyimpan objek-objek yang berada di dalam room
    private Grid objectGrid;

    // Atribut yang digunakan untuk menyimpan nama dari room
    private String name;

    // Atribut yang digunakan untuk menyimpan status selesainya room
    private boolean finished;

    // Konstruktor room dengan parameter titik awal, nama, dan status selesainya room
    public Room(Point point, String name, boolean finished) {
        // Memanggil konstruktor dari kelas induk (GridObject) dengan ukuran 6x6, karena room selalu memiliki ukuran 6x6
        super(point, 6, 6);

        // Membuat objek Grid dengan ukuran 6x6 untuk menyimpan objek-objek yang berada di dalam room
        objectGrid = new Grid(6, 6);

        // Mengatur nilai atribut name dengan parameter name yang diberikan
        this.name = name;

        // Mengatur nilai atribut finished dengan parameter finished yang diberikan
        finished = false;
    }

    // Metode untuk mengatur status selesainya room
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    // Metode untuk mendapatkan objek-objek yang berada di dalam room
    public List<GridObject> getObjects() {
        return objectGrid.getObjects();
    }

    // Metode untuk memindahkan Sim ke ruangan lain di rumah
    public void moveRoom(Sim sim, Room newRoom) {
        // Memeriksa apakah Sim sedang berada di dalam rumah ini
        if (sim.getCurrentRoom() == this) {
            // Memindahkan Sim ke ruangan baru
            sim.setCurrentRoom(newRoom);
            System.out.println("Sim berhasil berpindah ke " + newRoom.getName());
        } else {
            System.out.println("Sim tidak berada di dalam rumah ini!");
        }
    }

    // Metode untuk mengedit barang yang ada di dalam room
    public void editRoom() {
        Scanner input = new Scanner(System.in);
        // Memeriksa apakah Sim sedang berada di dalam ruangan ini
        if (Sim.getCurrentSim().getCurrentRoom() == this) {
            System.out.println("Pilih opsi:");
            System.out.println("1. Pembelian barang baru");
            System.out.println("2. Pemindahan barang");

            int option = input.nextInt();
            switch (option) {
                case 1:
                    // Meminta input barang yang ingin dibeli
                    System.out.println("Masukkan nama barang:");
                    String itemName = input.next();
                    System.out.println("Masukkan harga barang:");
                    double itemPrice = input.nextDouble();

                    // Membuat objek Item baru
                    Item newItem = new Item(itemName, itemPrice);

                    // Menambahkan objek Item baru ke dalam objekGrid
                    objectGrid.addObject(newItem);
                    System.out.println("Barang " + itemName + " berhasil ditambahkan ke dalam ruangan " + name);
                    break;
                case 2:
                    // Meminta input barang yang ingin dipindahkan
                    System.out.println("Masukkan nama barang yang ingin dipindahkan:");
                    String itemToMove = input.next();

                    // Mencari objek Item yang ingin dipindahkan
                    GridObject item = objectGrid.findObjectByName(itemToMove);

                    // Memeriksa apakah objek Item ditemukan
                    if (item == null) {
                        System.out.println("Barang " + itemToMove + " tidak ditemukan di dalam ruangan " + name);
                    } else {
                        // Memindahkan objek Item ke ruangan lain atau ke inventory Sim
                        System.out.println("Pilih opsi:");
                        System.out.println("1. Pindahkan ke ruangan lain");
                        System.out.println("2. Pindahkan ke inventory Sim");
                        int moveOption = input.nextInt();

                        if (moveOption == 1) {
                            // Meminta input ruangan tujuan
                            System.out.println("Masukkan nama ruangan tujuan:");
                            String destinationRoomName = input.next();

                            // Mencari ruangan tujuan
                            Room destinationRoom = Sim.getCurrentSim().getHouse().findRoomByName(destinationRoomName);

                            // Memeriksa apakah ruangan tujuan ditemukan
                            if (destinationRoom == null) {
                                System.out.println("Ruangan " + destinationRoomName + " tidak ditemukan di dalam rumah.");
                            } else {
                                // Memindahkan objek Item ke ruangan tujuan
                                objectGrid.removeObject(item);
                                destinationRoom.getObjectGrid().addObject(item);
                                System.out.println("Barang " + itemToMove + " berhasil dipindahkan ke ruangan " + destinationRoomName);
                            }
                        } else if (moveOption == 2) {
                            // Memindahkan objek Item ke inventory Sim
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
