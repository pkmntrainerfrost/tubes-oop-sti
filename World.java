import java.util.*;

public class World {

    // Implementasi World menggunakan Design Pattern Singleton
    private List<Sim> simList;
    private List<SimAction> actionList;
    private List<House> houseList;
    private Grid houseGrid;
    private SimActionMediator actionMediator;
    private static World instance = new World();
    private Scanner sc = new Scanner(System.in);
    private Sim currentSim;
    private int seconds;

    public World() {
        houseGrid = new Grid(64,64);
        simList = new ArrayList<>();
        actionList = new ArrayList<>();
        houseList = new ArrayList<>();
        actionMediator = actionMediator.getInstance();
        System.out.println("Write your character's name: ");
        String name = sc.nextLine();
        currentSim = new Sim(name);
    }

    public static World getInstance() {
        return instance;
    }

    public void resetWorld() {
        instance = new World(); // Menginstansiasi ulang instance agar bernilai baru
    }

    public List<SimAction> getActionList() {
        return actionList;
    }

    public void addHouseToWorld(House house){
        houseList.add(house);
    }

    public void addSim() {
        System.out.print("Masukkan nama Sim baru: ");
        String name = sc.nextLine();
        Sim sim = new Sim(name);
        simList.add(sim);
        System.out.println("Sim baru berhasil ditambahkan!");
    }

    public void changeSim() {
        System.out.println("Daftar Sim yang tersedia:");
        for (int i = 0; i < simList.size(); i++) {
            System.out.println((i+1) + ". " + simList.get(i).getName());
        }
        System.out.print("Pilih nomor Sim yang ingin dimainkan: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline character
        if (choice > 0 && choice <= simList.size()) {
            currentSim = simList.get(choice-1);
            System.out.println("Anda sekarang bermain sebagai Sim " + currentSim.getName());
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public EventManager getEvents() {
        return events;
    }
}
