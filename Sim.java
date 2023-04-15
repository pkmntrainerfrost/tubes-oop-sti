import java.util.Random;

public class Sim {

    private String name;
    private String job;
    private int kekenyangan=80;
    private int mood=80;
    private int kesehatan=80;
    private int uang=100;
    private String status="";
    private String inventory="";

    private static final String[] Jobs = {"Badut Sulap", "Koki", "Polisi", "Programmer", "Dokter", "Guru", "Penulis", "Musisi"};
    private static final Random RANDOM = new Random();

    public Sim(String name) {
        // Konstruktor
        this.name = name;
        this.job = JobGenerator();
    }
    public String JobGenerator() {
        int index = RANDOM.nextInt(Jobs.length);
        return Jobs[index];
    }
    public String PindahJob(){
        int index = RANDOM.nextInt(Jobs.length);
        return Jobs[index];
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
    public String getInventory() {
        return this.inventory;
    }
    public int getUang() {
        return this.uang;
    }
    public void work(){
        mood-=10;
        kekenyangan-=10;
    }
    public int getKesehatan(){
        return this.kesehatan;
    }
}