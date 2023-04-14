public class Sim {

    private String name;
    private String job=Job();
    private int kekenyangan=80;
    private int mood=80;
    private int kesehatan=80;
    private int uang=100;
    private String status="";
    private String inventory="";

    public Sim(String name) {
        // Konstruktor
        this.name=name;
    }
    public String Job() {
        String Job="random";
        return Job;
        // Mengeset mesin motor
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
    public int getKesehatan() {
        return this.kesehatan;
    }
    public String sound(){
        return "Ngenggg";
    }
}