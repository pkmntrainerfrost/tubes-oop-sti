import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Sim {

    private String name;
    private String job;
    private int kekenyangan=80;
    private int mood=80;
    private int kesehatan=80;
    private int uang=100;
    private String status="";
    private Set<String> inventory;

    private static final String[] Jobs = {"Badut Sulap", "Koki", "Polisi", "Programmer", "Dokter", "Guru", "Penulis", "Musisi"};
    private static final Random RANDOM = new Random();

    public Sim(String name) {
        this.name = name;
        this.job = JobGenerator();
        this.inventory = new HashSet<>();;
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
    public int getUang() {
        return this.uang;
    }
    public int getKesehatan(){
        return this.kesehatan;
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

    public Set<String> getInventory() {
        return this.inventory;
    }
    public void addItemToInventory(String item) {
        this.inventory.add(item);
    }
    public void work(){
        mood-=10;
        kekenyangan-=10;
    }

}