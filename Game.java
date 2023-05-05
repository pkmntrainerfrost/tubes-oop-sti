import java.util.*;

public class Game {
    
    private Map<String, Job> jobMap;
    private Map<String, Item> itemMap;

    private Map<String, Sim> simMap;
    
    private List<SimPassiveAction> currentPassiveActions;

    private Sim currentSim;

    private SimActiveAction currentActiveAction;

    private Clock clock = Clock.getInstance();
    private World world = World.getInstance();

    private static Game instance = new Game();

    private Game() {
        
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

    public List<SimPassiveAction> getPassiveAction() {
        return currentPassiveActions;
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
        List<Sim> simList = new ArrayList<Sim>(simMap.values());
        for (int i = 0; i < simList.size(); i++) {
            System.out.println((i+1) + ". " + simList.get(i).getName());
        }
        System.out.println("Pilih nomor Sim yang ingin dimainkan: ");

        /*
        for (int i = 0; i < Mediator.getSimList().size(); i++) {
            System.out.println((i+1) + ". " + Mediator.getSimList().get(i).getName());
        }
        System.out.print("Pilih nomor Sim yang ingin dimainkan: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline character
        if (choice > 0 && choice <= Mediator.getSimList().size()) {
            currentSim = Mediator.getSimList().get(choice-1);
            System.out.println("Anda sekarang bermain sebagai Sim " + currentSim.getName());
        } else {
            System.out.println("Pilihan tidak valid!");
        }
        */
    }

    public Sim getCurrentSim() {
        return currentSim;
    }

    public SimActiveAction getCurrentActiveAction() {
        return currentActiveAction;
    }

    public void setCurrentActiveAction(SimActiveAction currActiveAction) {
        this.currentActiveAction = currentActiveAction;
    }

    public void initializeGame(String firstSimName) {
        world.resetWorld();
        clock.resetClock();
        addSim(firstSimName);
        
    }


}
