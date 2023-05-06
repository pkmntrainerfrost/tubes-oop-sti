import java.util.*;

public class Sim {

    private static final Item Item = null;
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
    public boolean isDead() {
        return mood <= 0 || kekenyangan <= 0 || kesehatan <= 0;
    }

    // Method untuk memindahkan sim ke room baru
    public void moveRoom() {
        // Cek apakah sim saat ini berada di dalam room ini
        for (GridObject room : currentHouse.getRoomList()) {
            System.out.println("List of room to go: ");
            System.out.println(((Room) room).getRoomName());
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Choose which room to go: ");
        String roomName = in.nextLine();
        Room newRoom = getCurrentRoom();
        for (GridObject room : currentHouse.getRoomList()) {
            if (roomName.equals(((Room) room).getRoomName())){
                newRoom = (Room) room;
            }
        }
        if (newRoom != getCurrentRoom()){
            setCurrentRoom(newRoom);
            setCurrentPosition(newRoom.getPoint());
            System.out.println("sim successfully moved to " + newRoom.getRoomName());
        }else{
            System.out.println("sim is already in " + newRoom.getRoomName());
        }
    }

    public void buyItem(){
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = getInventory();
        if (currentRoom == null) {
            System.out.println("Anda tidak berada dalam ruangan saat ini.");
        }else{
            System.out.println("Daftar barang yang tersedia:");
            Inventory[] availableItems = Inventory.getItem();
            for (int i = 0; i < availableItems.length; i++) {
                System.out.println((i + 1) + ". " + availableItems[i].getItem() + " (" + availableItems[i].getPrice() + ")");
            }
    
            System.out.print("Pilih barang yang ingin dibeli (masukkan nomor): ");
            int itemNumber = scanner.nextInt();
            scanner.nextLine(); 
    
            if (itemNumber < 1 || itemNumber > availableItems.length) {
                System.out.println("Nomor barang tidak valid.");
                return;
            }
    
            Inventory selectedItem = availableItems[itemNumber - 1];
            int totalPrice = selectedItem.getPrice();
    
            if (getUang() < totalPrice) {
                System.out.println("Uang Anda tidak cukup untuk membeli barang ini.");
                return;
            }
    
            inventory.addItem(Item, 1);
            setUang(getUang() - totalPrice);
            System.out.println("Barang " + selectedItem.getItem() + " berhasil dibeli dan dimasukkan ke inventory.");
        }

    }
    
    public void moveItem() {
        Scanner scanner = new Scanner(System.in);

        // Menampilkan daftar furniture beserta point pada gridnya
        List<GridObject> furnitureList = getCurrentRoom().getFurnitureList();
        for (int i = 0; i < furnitureList.size(); i++) {
            FurnitureObject furnitureObject = (FurnitureObject) furnitureList.get(i);
            System.out.println(i + 1 + ". " + furnitureObject.getFurniture().getItemName() + " (" + furnitureObject.getPoint().getX() + ", " + furnitureObject.getPoint().getY() + ")");
        }

        // Meminta input dari pengguna untuk memilih furniture yang ingin dipindahkan
        System.out.print("Pilih nomor furniture yang ingin dipindahkan: ");
        int furnitureIndex = scanner.nextInt() - 1;

        // Memindahkan furniture dari room ke inventory jika furniture yang dipilih valid
        if (furnitureIndex >= 0 && furnitureIndex < furnitureList.size()) {
            FurnitureObject furnitureObject = (FurnitureObject) furnitureList.get(furnitureIndex);

            // Menghapus FurnitureObject dari Room
            getCurrentRoom().getObjectGrid().removeObject(furnitureObject.getPoint());

            // Menambahkan FurnitureType ke Inventory
            FurnitureType furnitureType = furnitureObject.getFurniture();
            InventoryItem item = new InventoryItem(Item, 1);
            getInventory().addItem(Item, 1);

            System.out.println("Furniture " + furnitureType.getItemName() + " berhasil dipindahkan ke inventory.");
        } else {
            System.out.println("Nomor furniture tidak valid.");
        }
    }



    public void putItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama barang yang ingin dipasang: ");
        String itemTobuy = scanner.nextLine();
        InventoryItem item = InventoryItem.getName();

        if (itemTobuy == null) {
            System.out.println("Barang tidak ditemukan dalam inventory.");
            return;
        }

        if (!(item instanceof InventoryItem)) {
            System.out.println("Barang tidak dapat dipasang.");
            return;
        }

        InventoryItem buyableItem = (InventoryItem) item;

        try {
            inventory.addItem(Item, 1);
            inventory.removeItem(itemTobuy, 1);;
            System.out.println("Barang " + item + " berhasil dipasang di ruangan " + currentRoom.getRoomName() + ".");
        } catch (ItemNotInInventoryException e) {
            System.out.println("Barang tidak dapat dipasang.");
        }
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

    public void displaySimInfo() throws SimNotInGameException{
        try {
            System.out.println("Sim Information:");
            System.out.println("====================================");
            System.out.println("Sim Name: " + getName());
            System.out.println("Sim Job: " + getjob().getName());
            System.out.println("Sim Health: " + getKesehatan());
            System.out.println("Sim Fullness: " + getKekenyangan());
            System.out.println("Sim Mood: " + getMood());
            System.out.println("Sim Money: " + getUang());
        } catch (Exception e) {
            // TODO: handle exception
            throw new SimNotInGameException("Sim is not in the house!");
        }
    }
    public void displayCurrentLocation() throws SimNotInGameException {
        System.out.println(getName() + "is in house" + getCurrentHouse().getHouseName() + " and in room: " + getCurrentRoom().getRoomName());
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
}

class SimNotInGameException extends Exception {
    public SimNotInGameException(String errorMessage) {
        super(errorMessage);
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
      


