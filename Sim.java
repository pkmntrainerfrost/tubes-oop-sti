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

    public Inventory getInventory() {
        return this.inventory;
    }
    public void addItemToInventory(String item, String category, int quantity) {
        this.inventory.addItem(item, category, quantity);
    }
    public void setInHouse(boolean isInHouse){
        this.inHouse = isInHouse;
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
            System.out.println("Current Location: " + getInventory().getCurrentRoom().getRoomName());
        } catch (Exception e) {
            throw new SimNotInGameException("Sim is not in any room!");
        }
    }
}

class SimNotInGameException extends Exception {
    public SimNotInGameException(String errorMessage) {
        super(errorMessage);
    }
}