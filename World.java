import java.util.*;

public class World {

    // Implementasi World menggunakan Design Pattern Singleton

    private List<Sim> simList;
    private List<Action> actionList;

    private Grid houseGrid;

    private static ActionMediator actionMediator;

    private Sim currentSim;

    private static World instance = new World();

    private Scanner sc = new Scanner(System.in);

    public World() {
        houseGrid = new Grid(64,64);
        simList = new ArrayList<>();
        actionList = new ArrayList<>();
        actionMediator = ActionMediator.getInstance();
        System.out.println("Choose your sim name");
        String simName = sc.nextLine();
        currentSim = new Sim(simName);
    }

    public static World getInstance() {
        return instance;
    }

    public void resetWorld(World newWorld) {
        instance = newWorld;
    }

    public List<Action> getActionList() {
        return actionList;
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
}
