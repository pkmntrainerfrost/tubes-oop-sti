import java.util.*;

public class Sim {

    private String name;
    private String job;
    private int kekenyangan=80;
    private int mood=80;
    private int kesehatan=80;
    private int uang=100;
    private String status="";
    private Inventory inventory;
    private boolean inHouse;

    private static final String[] Jobs = {"Badut Sulap", "Koki", "Polisi", "Programmer", "Dokter", "Guru", "Penulis", "Musisi"};
    private static final Random RANDOM = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Sim> Sims = new ArrayList<>();

    public Sim(String name) {
        this.name = name;
        this.job = JobGenerator();
        this.inventory = new Inventory();
        this.inHouse = true;
    }
    public String JobGenerator() {
        int index = RANDOM.nextInt(Jobs.length);
        return Jobs[index];
    }
    public String PindahJob(){
        return Job.getJobChoices();
    }
    public String getName() {
        return this.name;
    }
    public String getjob() {
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

    public void setStatus(String status) {
        this.status = status;
    }

    public Inventory getSimInventory() {
        return this.inventory;
    }

    public void setInHouse(boolean isInHouse){
        this.inHouse = isInHouse;
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

    











    
}

class SimNotInGameException extends Exception {
    public SimNotInGameException(String errorMessage) {
        super(errorMessage);
    }
}