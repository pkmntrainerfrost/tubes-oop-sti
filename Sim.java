import java.util.*;

public class Sim {

    private String name;
    private Job job;

    private int kekenyangan = 80;
    private int mood = 80;
    private int kesehatan = 80;
    private int uang = 100;

    private boolean busy = false;

    private int workSeconds = 0;
    private int visitSeconds = 0;
    private boolean isVisiting = false;
    private boolean peeCycle = false;
    private boolean sleepCycle = true;
    private int peeCycleStart;
    private int sleepCycleStart;
    private int visitStart;

    private Inventory inventory = new Inventory();
    private House currentHouse;
    private Room currentRoom;
    private Point currentPosition;
    
    public Sim(String name) {

        this.name = name;

        Collection<String> jobs = Game.getInstance().getJobMap().keySet();
        String[] jobArray = jobs.toArray(new String[0]);
        this.job = Game.getInstance().getJobMap().get(jobArray[((int) (Math.random() * jobArray.length))]);

        startSimTimers();

    }

    public void startSimTimers() {

        Clock clock = Clock.getInstance();

        // timer kencing
        new Thread(() -> {
            while (true) {
                peeCycleStart = clock.getSeconds();
                while (peeCycle) {
                    while (clock.getRunning()) {
                        if (clock.getSeconds() >= peeCycleStart + 240) {
                            peeCycle = false;
                            addMood(-5);
                            addKesehatan(-5);
                        }
                    }
                }
            }
        }).start();

        // timer tidur
        new Thread(() -> {
            while (true) {
                sleepCycleStart = clock.getSeconds();
                while (sleepCycle) {
                    while (clock.getRunning()) {
                        if (clock.getSeconds() >= sleepCycleStart + 600) {
                            sleepCycleStart = clock.getSeconds();
                            addMood(-5);
                            addKesehatan(-5);
                        }
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                visitStart = clock.getSeconds();
                while (isVisiting) {
                    while (clock.getRunning()) {
                        visitSeconds = clock.getSeconds() - visitStart;
                    }
                }
            }
        }).start();

    }

    /* getter */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Job getjob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getKekenyangan() {
        return kekenyangan;
    }

    public void setKekenyangan(int kekenyangan) {
        this.kekenyangan = kekenyangan;
    }

    public void addKekenyangan(int kekenyangan) {
        this.kekenyangan += kekenyangan;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public void addMood(int mood) {
        this.mood += mood;
    }

    public int getUang() {
        return uang;
    }

    public void setUang(int uang) {
        this.uang = uang;
    }

    public void addUang(int uang) {
        this.uang += uang;
    }

    public int getKesehatan(){
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public void addKesehatan(int kesehatan) {
        this.kesehatan += kesehatan;
    }

    public boolean getBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public int getWorkSeconds() {
        return workSeconds;
    }

    public void setWorkSeconds(int seconds) {
        this.workSeconds = seconds;
    }

    public void addWorkSeconds(int seconds) {
        this.workSeconds += seconds;
    }

    public synchronized boolean getIsVisiting() {
        return isVisiting;
    }

    public synchronized void setIsVisiting(boolean isVisiting) {
        this.isVisiting = isVisiting;
    }

    public synchronized int getVisitSeconds() {
        return visitSeconds;
    }

    public synchronized boolean getPeeCycle() {
        return peeCycle;
    }

    public synchronized void setPeeCycle(boolean peeCycle) {
        this.peeCycle = peeCycle;
    }

    public synchronized boolean getSleepCycle() {
        return sleepCycle;
    }

    public synchronized void setSleepCycle(boolean sleepCycle) {
        this.sleepCycle = sleepCycle;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public House getCurrentHouse () {
        return currentHouse;
    }

    public void setCurrentHouse(House newHouse) {
        this.currentHouse = newHouse;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }
    
    public Point getCurrentPoisition() {
        return currentPosition;
    }

    public void setCurrentPosition(Point simPosition){
        this.currentPosition = simPosition;
    }

    public Job getPekerjaan() {
        return job;
    }

}

/* 

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

    public Point getSimPosition(){
        return simPosition;
    }

    public void setSimPosition(Point point){
        this.simPosition = point;
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

    /* 
    public void setWorkSeconds(int workSeconds){
        this.workSeconds = workSeconds;
    }

    // aksi melihat inventory
    // ini buat apa?? udah ada display inventory terus cuma nambah text atasnya??
    public void seeInventory() {
        System.out.println("Berikut merupakan inventory yang dimiliki oleh :" + getName());
        // getSimInventory().displayInventory(); // ini kelas inventorynya belum di fix yah, jadi tunggu dulu
    }

    // aksi go to object
    public void goToObject(String simName, String furnitureName){
        if (simName.equals(this.getName())){
            if (furnitureName.equals(getCurrentRoom().findFurnitureName(furnitureName))) {
                setCurrentPosition(getCurrentRoom().getItem(furnitureName).getPoint());
                System.out.println("Sim " + simName + " telah berhasil pindah!");
            } else {
                System.out.println("Maaf nama objek tidak ada di ruangan saat ini");
            }
        } else {
            System.out.println("Maaf nama sim tidak sesuai dengan sim yang ada");
        }
    }

    // display Go To Object
    public void displayGoToObject() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama Sim yang ingin menuju posisi Objek: ");
        String namaSim = scanner.next();
        System.out.print("Masukkan nama Objek yang ingin dituju: ");
        String namaObjek = scanner.next();

        this.goToObject(namaSim, namaObjek);
    }

    public void editRoom() throws ItemNotInInventoryException, InvalidQuantityException, SimMiskinException {
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
        System.out.println("Masukkan angka dari aksi yang ingin dilakukan: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 
        //masih belum selesai ya ini
        switch (choice) {
            case 1:
                System.out.println("Daftar barang yang tersedia:");
                Items[] availableItems = Items.values();
                for (int i = 0; i < availableItems.length; i++) {
                    System.out.println((i + 1) + ". " + availableItems[i].getItemName() + " (" + availableItems[i].getPrice() + ")");
                }

                System.out.print("Pilih barang yang ingin dibeli (masukkan nomor): ");
                int itemNumber = scanner.nextInt();
                scanner.nextLine(); 

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
                System.out.println("Pindahkan barang ke inventory");

                int moveChoice = scanner.nextInt();
                scanner.nextLine(); 

                if (moveChoice != 1) {
                    System.out.println("Pilihan tidak valid.");
                    return;
                }

                System.out.print("Masukkan nama barang yang ingin dipindahkan: ");
                String itemName = scanner.nextLine();

                if (inventory.getItem(itemName) == null) {
                    System.out.println("Barang tidak ditemukan dalam inventory.");
                    return;
                }

                int quantity = inventory.getItemQuantity(itemName);

                if (quantity < 1) {
                    System.out.println("Jumlah barang tidak mencukupi.");
                    return;
                }
                inventory.removeItem(itemName, 1);
                Items items = getSimInventory().getItem(itemName);
                currentRoom.removeItem(itemName, 1);

                System.out.println("Barang " + itemName + " berhasil dipindahkan ke ruangan " + currentRoom.getRoomName() + ".");

                break;

            case 3:
                System.out.print("Masukkan nama barang yang ingin dipasang: ");
                String itemNameTobuy = scanner.nextLine();

                Items itemTobuy = inventory.getItem(itemNameTobuy);

                if (itemTobuy == null) {
                    System.out.println("Barang tidak ditemukan dalam inventory.");
                    return;
                }

                if (!(itemTobuy instanceof Stuffs)) {
                    System.out.println("Barang tidak dapat dipasang.");
                    return;
                }

                FurnitureObject buyableItem = (FurnitureObject) itemTobuy;

                try {
                    currentRoom.buyItem(buyableItem);
                    inventory.removeItem(itemNameTobuy, 1);
                    System.out.println("Barang " + itemNameTobuy + " berhasil dipasang di ruangan " + currentRoom.getRoomName() + ".");
                } catch (ItemNotInInventoryException e) {
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

*/

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
      


