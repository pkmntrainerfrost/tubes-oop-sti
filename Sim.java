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

    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Sim> Sims = new ArrayList<>();

    public Sim(String name) {
        this.name = name;
        int randomJob = (int) (Math.random() * 5) + 1;
        switch (randomJob) {
            case 1:
                this.job = new BadutSulap();
                break;
            case 2:
                this.job = new Koki();
                break;
            case 3:
                this.job = new Polisi();
                break;
            case 4:
                this.job = new Programmer();
                break;
            case 5:
                this.job = new Dokter();
                break;
            default:
                break;
        }
        this.inventory = new Inventory();
        this.inHouse = true;
    }
    public String PindahJob(){
        return Job.getJobChoices();
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

    public static void addSim() {
        System.out.print("Masukkan nama Sim baru: ");
        String name = scanner.nextLine();
        Sim Sim = new Sim(name);
        Sims.add(Sim);
        System.out.println("Sim baru berhasil ditambahkan!");
    }
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
            try {
                System.out.println("Current Location: " + getCurrentRoom().getRoomName());
            } catch (Exception e) {
                throw new SimNotInGameException("Sim is not in any room!");
            }
        }
    }
}

public void displayCurrentLocation() throws SimNotInGameException {
    if (getInHouse()) {
        System.out.println("Current Location: Rumah");
    } else {
        try {
            System.out.println("Current Location: " + getSimInventory().getCurrentRoom().getRoomName());
        } catch (Exception e) {
            throw new SimNotInGameException("Sim is not in any room!");
        }
    }
}
class SimNotInGameException extends Exception {
    public SimNotInGameException(String errorMessage) {
        super(errorMessage);
    }
}}






