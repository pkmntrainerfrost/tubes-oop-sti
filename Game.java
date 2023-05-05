import java.util.*;

public class Game {
    
    private Map<String, Job> jobMap;
    private Map<String, Item> itemMap;

    private Map<String, Sim> simMap;
    private Map<Sim, SimAction> currentActionMap; 

    private Sim currentSim;

    private SimAction currentActiveAction;

    private Clock clock = Clock.getInstance();
    private World world = World.getInstance();

    private static Game instance = new Game();

    private Game() {
        GameBuilder gameBuilder = new NewGameBuilder();
        this.instance = gameBuilder.getGame();
    }

    private Game(boolean load) {
        GameBuilder gameBuilder = load ? new LoadGameBuilder() : new NewGameBuilder();
        this.instance = gameBuilder.getGame();
    }

    public Map<String, Job> getJobMap() {
        return jobMap;
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }

    public Map<String, Sim> getSimMap() {
        return simMap;
    }

    public Map<Sim, SimAction> getActionMap() {
        return currentActionMap;
    }

    public static Game getInstance() {
        return instance;
    }

    public void addSim(String name) {
        Sim sim = new Sim(name);
        simMap.put("name", sim);
        System.out.println(sim.getName() + " successfully added!");
    }

    public void changeSim() {
        System.out.println("Daftar Sim yang tersedia:");
        for (int i = 0; i < simMediator.getSimList().size(); i++) {
            System.out.println((i+1) + ". " + simMediator.getSimList().get(i).getName());
        }
        System.out.print("Pilih nomor Sim yang ingin dimainkan: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline character
        if (choice > 0 && choice <= simMediator.getSimList().size()) {
            currentSim = simMediator.getSimList().get(choice-1);
            System.out.println("Anda sekarang bermain sebagai Sim " + currentSim.getName());
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }



}
