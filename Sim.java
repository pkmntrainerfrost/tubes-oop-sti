import java.util.*;

public class Sim {

    private String name;
    private Jobs job;
    private int kekenyangan=80;
    private int mood=80;
    private int kesehatan=80;
    private int uang=10000;
    private int workSeconds;
    private String status="";
    private Inventory inventory;
    private boolean inHouse;
    private Room currentRoom;
    private static final Random RANDOM = new Random();
    private static final Jobs[] jobChoices = {new MagicClown(), new Chef(), new Police(), new Programmer(), new Doctor()};

    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Sim> Sims = new ArrayList<>();
    private Room[] getRooms() {
        return null;
    }

    public Sim(String name) {
        this.name = name;
        int randomJob = (int) (Math.random() * 5) + 1;
        switch (randomJob) {
            case 1:
                this.job = new MagicClown();
                break;
            case 2:
                this.job = new Chef();
                break;
            case 3:
                this.job = new Police();
                break;
            case 4:
                this.job = new Programmer();
                break;
            case 5:
                this.job = new Doctor();
                break;
            default:
                break;
        }
        //this.inventory = new Inventory();
        this.inHouse = true;
    }
    public Jobs getJobChoices() {
        int index = RANDOM.nextInt(jobChoices.length);
        return jobChoices[index];
    }
    public Jobs PindahJob(){
        return getJobChoices();
    }
    public String getName() {
        return this.name;
    }
    public Jobs getjob() {
        return this.job;
    }
    public int getKekenyangan() {
        return this.kekenyangan;
    }
    public int getMood() {
        return this.mood;
    }
    public String getStatus() {
        return this.status;
    }
    public int getUang() {
        return this.uang;
    }
    public int getKesehatan(){
        return this.kesehatan;
    }
    public boolean getInHouse(){
        return this.inHouse;
    }
    public int getWorkSeconds() {
        return this.workSeconds;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setKekenyangan(int kekenyangan) {
        this.kekenyangan = kekenyangan;
    }
    public void setMood(int mood) {
        this.mood = mood;
    }
    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }
    public void setUang(int uang) {
        this.uang = uang;
    }
    public Jobs getPekerjaan() {
        return this.job;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Inventory getSimInventory() {
        return this.inventory;
    }
    public void setPekerjaan(Jobs job) {
        this.job = job;
    }
    public void setInHouse(boolean isInHouse){
        this.inHouse = isInHouse;
    }
    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }
    public Room getCurrentRoom(){
        return this.currentRoom;
    }
    public static ArrayList<Sim> getSims(){
        return Sims;
    }

    // aksi tambah Sim
    public static void addSim() {
        System.out.print("Masukkan nama Sim baru: ");
        String name = scanner.nextLine();
        Sim Sim = new Sim(name);
        Sims.add(Sim);
        System.out.println("Sim baru berhasil ditambahkan!");
    }

    // aksi ubah Sim
    public static void changeSim() {
        System.out.println("Daftar Sim yang tersedia:");
        for (int i = 0; i < Sims.size(); i++) {
            System.out.println((i+1) + ". " + Sims.get(i).name);
        }
        System.out.print("Pilih nomor Sim yang ingin dimainkan: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        if (choice > 0 && choice <= Sims.size()) {
            Sim Sim = Sims.get(choice-1);
            System.out.println("Anda sekarang bermain sebagai Sim " + Sim.name);
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    public void displaySimInfo() throws SimNotInGameException{
        if (getInHouse()){
            try {
                System.out.println("Sim Information:");
                System.out.println("====================================");
                System.out.println("Nama Sim: " + getName());
                System.out.println("Pekerjaan Sim: " + getjob());
                System.out.println("Kesehatan Sim: " + getKesehatan());
                System.out.println("Kekenyangan Sim: " + getKekenyangan());
                System.out.println("Mood Sim: " + getMood());
                System.out.println("Uang Sim: " + getUang());
            } catch (Exception e) {
                // TODO: handle exception
                throw new SimNotInGameException("Sim is not in the house!");
            }
        }
    }
    public void displayCurrentLocation() throws SimNotInGameException {
        if (getInHouse()) {
            System.out.println("Current Location: Rumah");
        } else {
            if (getCurrentRoom() == null) {
                throw new SimNotInGameException("Sim is not in a room!");
            }
            System.out.println("Current Location: " + getCurrentRoom().getRoomName());
        }
    }    

    public void setWorkSeconds(int workSeconds){
        this.workSeconds = workSeconds;
    }

    // aksi melihat inventory
    public void seeInventory() {
        System.out.println("Berikut merupakan inventory yang dimiliki oleh :" + getName());
        // getSimInventory().displayInventory(); // ini kelas inventorynya belum di fix yah, jadi tunggu dulu
    }

    public void editRoom() throws ItemNotInInventoryException, InvalidQuantityException {
        if (currentRoom == null) {
            System.out.println("Anda tidak berada dalam ruangan saat ini.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Inventory inventory = getSimInventory();

        System.out.println("Menu Edit Room:");
        System.out.println("1. Beli barang baru");
        System.out.println("2. Pindah barang");
        System.out.println("3. Pasang barang");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume new line character after calling nextInt()

        switch (choice) {
            case 1:
                System.out.println("Daftar barang yang tersedia:");
                Items[] availableItems = Items.values();
                for (int i = 0; i < availableItems.length; i++) {
                    System.out.println((i + 1) + ". " + availableItems[i].getItemName() + " (" + availableItems[i].getPrice() + ")");
                }

                System.out.print("Pilih barang yang ingin dibeli (masukkan nomor): ");
                int itemNumber = scanner.nextInt();
                scanner.nextLine(); // consume new line character after calling nextInt()

                if (itemNumber < 1 || itemNumber > availableItems.length) {
                    System.out.println("Nomor barang tidak valid.");
                    return;
                }

                Items selectedItem = availableItems[itemNumber - 1];
                int totalPrice = selectedItem.getPrice();

                if (getUang() < totalPrice) {
                    System.out.println("Uang Anda tidak cukup untuk membeli barang ini.");
                    return;
                }

                inventory.addItem(selectedItem, 1);
                setUang(getUang() - totalPrice);
                System.out.println("Barang " + selectedItem.getItemName() + " berhasil dibeli dan dimasukkan ke inventory.");

                break;
            case 2:
                System.out.println("1. Pindahkan barang ke ruangan lain");
                System.out.println("2. Pindahkan barang ke inventory");

                int moveChoice = scanner.nextInt();
                scanner.nextLine(); // consume new line character after calling nextInt()

                if (moveChoice < 1 || moveChoice > 2) {
                    System.out.println("Pilihan tidak valid.");
                    return;
                }

                System.out.print("Masukkan nama barang yang ingin dipindahkan: ");
                String itemName = scanner.nextLine();

                if (moveChoice == 1) {
                    Room[] rooms = getRooms();
                    System.out.println("Daftar ruangan yang tersedia:");
                    for (int i = 0; i < rooms.length; i++) {
                        if (!rooms[i].equals(currentRoom)) {
                            System.out.println((i + 1) + ". " + rooms[i].getRoomName());
                        }
                    }

                    System.out.print("Pilih ruangan tujuan (masukkan nomor): ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // consume new line character after calling nextInt()

                    if (roomNumber < 1 || roomNumber > rooms.length - 1) {
                        System.out.println("Nomor ruangan tidak valid.");
                        return;
                    }

                    Room destinationRoom = rooms[roomNumber - 1];

                    if (currentRoom.getItem(itemName) == null) {
                        System.out.println("Barang tidak ditemukan dalam ruangan ini.");
                        return;
                    }

                    int quantity = currentRoom.getItemQuantity(itemName);
                    if (quantity < 1) {
                        System.out.println("Jumlah barang tidak mencukupi.");
                        return;
                    }
                    Items itemToMove = currentRoom.removeItem(itemName, 1);
                    destinationRoom.addItem(itemToMove, 1);

                    System.out.println("Barang " + itemName + " berhasil dipindahkan ke ruangan " + destinationRoom.getRoomName() + ".");
                } else {
                    if (inventory.getItem(itemName) == null) {
                        System.out.println("Barang tidak ditemukan dalam inventory.");
                        return;
                    }

                    int quantity = inventory.getItemQuantity(itemName);

                    if (quantity < 1) {
                        System.out.println("Jumlah barang tidak mencukupi.");
                        return;
                    }

                    Items itemToMove = inventory.removeItem(itemName, 1);
                    currentRoom.addItem(itemToMove, 1);

                    System.out.println("Barang " + itemName + " berhasil dipindahkan ke ruangan " + currentRoom.getRoomName() + ".");
                }

                break;
            case 3:
                System.out.print("Masukkan nama barang yang ingin dipasang: ");
                String itemNameToInstall = scanner.nextLine();

                Items itemToInstall = inventory.getItem(itemNameToInstall);

                if (itemToInstall == null) {
                    System.out.println("Barang tidak ditemukan dalam inventory.");
                    return;
                }

                if (!(itemToInstall instanceof InstallableItem)) {
                    System.out.println("Barang tidak dapat dipasang.");
                    return;
                }

                InstallableItem installableItem = (InstallableItem) itemToInstall;

                try {
                    currentRoom.installItem(installableItem);
                    inventory.removeItem(itemNameToInstall, 1);
                    System.out.println("Barang " + itemNameToInstall + " berhasil dipasang di ruangan " + currentRoom.getRoomName() + ".");
                } catch (ItemNotInstallableException e) {
                    System.out.println("Barang tidak dapat dipasang.");
                }

                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

}

class SimNotInGameException extends Exception {
    public SimNotInGameException(String errorMessage) {
        super(errorMessage);
    }
}



/*
    public void editRoom(Room room) {
        Scanner input = new Scanner(System.in);

        // Check if the sim is currently in this room
        if (this.getCurrentRoom() == room) {
            System.out.println("Pilih opsi:");
            System.out.println("1. Pembelian barang baru");
            System.out.println("2. Pemindahan barang");
            System.out.println("3. Memasang barang");

            int option = input.nextInt();
            switch (option) {
                // Case 1: Purchase new non-food item and add to sim's inventory
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String itemName = input.next();
                    System.out.print("Masukkan harga barang: ");
                    double itemPrice = input.nextDouble();

                    // Check if item is a non-food item
                    if (!(itemName.equals("makanan") || itemName.equals("minuman"))) {
                        try {
                            // Purchase item and add to inventory
                            Sim.getCurrentSim().getInventory().addItem(new Items(itemName, itemPrice), 1);
                            System.out.println("Barang " + itemName + " berhasil dibeli dan ditambahkan ke inventory sim " + getName());
                        } catch (InvalidQuantityException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Maaf, barang " + itemName + " tidak bisa dibeli");
                    }
                    break;

                // Case 2: Move item to another room or sim's inventory
                case 2:
                    System.out.print("Masukkan nama barang yang ingin dipindahkan: ");
                    String itemToMove = input.next();
                    GridObject item = objectGrid.findObjectByName(itemToMove);
                    if (item == null) {
                        System.out.println("Barang " + itemToMove + " tidak ditemukan di dalam ruangan " + name);
                    } else {
                        System.out.println("Pilih opsi:");
                        System.out.println("1. Pindahkan ke ruangan lain");
                        System.out.println("2. Pindahkan ke inventory Sim");
                        int moveOption = input.nextInt();
                        // Case 1: Move item to another room
                        if (moveOption == 1) {
                            System.out.println("Masukkan nama ruangan tujuan: ");
                            String destinationRoomName = input.next();
                            Room destinationRoom = Sim.getCurrentSim().getHouse().findRoomByName(destinationRoomName);
                            if (destinationRoom == null) {
                                System.out.println("Ruangan " + destinationRoomName + " tidak ditemukan di dalam rumah.");
                            } else {
                                objectGrid.removeObject(item);
                                destinationRoom.getObjectGrid().addObject(item);
                                System.out.println("Barang " + itemToMove + " berhasil dipindahkan ke ruangan " + destinationRoomName);
                            }
                        // case 2: Move item to sim's inventory
                        } else if (moveOption == 2) {
                            Sim.getCurrentSim().getInventory().addItem((Items)item, 1);
                            objectGrid.removeObject(item);
                            System.out.println("Barang " + itemToMove + " berhasil dipindahkan ke inventory Sim");
                        } else {
                            System.out.println("Opsi yang dimasukkan tidak valid");
                        }
                    }
                    break;

                // Case 3: Place item in room
                case 3:
                    System.out.print("Masukkan nama barang yang ingin dipasang: ");
                    String itemToPlace = input.next();
                    InventoryItem inventoryItem = null;
                    for (InventoryItem item : inventory) {
                        if (item.getName().equals(itemToPlace)) {
                            inventoryItem = item;
                            break;
                        }
                    }
                    if (inventoryItem == null) {
                        System.out.println("Item tidak ada di dalam inventory");
                    } else {
                        inventory.remove(inventoryItem);
                        currentRoom.addItem(inventoryItem);
                        System.out.println("Item " + inventoryItem.getName() + " telah dipasang di ruangan " + currentRoom.getName());
                    }
                    break;
            }
        }
    }
*/
      


