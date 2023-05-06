import java.util.*;

public class Game {
    
    private Map<String, Job> jobMap = new HashMap<>();
    private Map<String, Item> itemMap = new HashMap<>();

    private Map<String, Sim> simMap = new HashMap<>();
    
    private Map<Sim,List<SimPassiveAction>> currentPassiveActions = new HashMap<>();

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

    public Map<Sim,List<SimPassiveAction>> getPassiveAction() {
        return currentPassiveActions;
    }

    public static Game getInstance() {
        return instance;
    }

    public void addSim(String name) {
        Sim sim = new Sim(name);
        simMap.put(name, sim);
        Point p = new Point(0,0);
        House house = new House(p, sim);
        sim.setCurrentHouse(house);
        sim.setCurrentRoom(house.getMainRoom());
        sim.setCurrentPosition(new Point(0, 0));
        sim.setRumah(house);
    }

    public void changeSim() {
        System.out.println("Daftar Sim yang tersedia:");
        List<Sim> simList = new ArrayList<Sim>(simMap.values());
        for (int i = 0; i < simList.size(); i++) {
            System.out.println((i+1) + ". " + simList.get(i).getName());
        }
        System.out.println("Pilih nomor Sim yang ingin dimainkan: ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        while (choice < 1 || choice > simList.size()) {
            System.out.println("Nomor Sim tidak valid. Pilih nomor Sim yang ingin dimainkan: ");
            choice = scan.nextInt();
        }
        currentSim = simList.get(choice-1);
        System.out.println("Sim yang dipilih: " + currentSim.getName());    

    }
    public synchronized void updateMap() {
        List<Sim> deadSim = new ArrayList<>();
        for (Sim sim : simMap.values()) {
            if (sim.checkDie()) {
                System.out.println(sim.getName() + " mati");
                deadSim.add(sim);
            }
        }
        for (Sim sim : deadSim) {
            simMap.remove(sim.getName());
        }
    }
    public Sim getCurrentSim() {
        return currentSim;
    }

    public SimActiveAction getCurrentActiveAction() {
        return currentActiveAction;
    }

    public void setCurrentActiveAction(SimActiveAction currActiveAction) {
        this.currentActiveAction = currActiveAction;
    }

    public void initializeGame(String firstSimName) {
        world.resetWorld();
        clock.resetClock();
        world = World.getInstance();
        clock = Clock.getInstance();
        Thread clockThread = new Thread(clock);
        clockThread.start();
        jobMap = JSONReader.readJobs();
        itemMap = JSONReader.readItems();
        Sim firstSim = new Sim(firstSimName);
        simMap.put("firstSimName", firstSim);
        Point firstHousePoint = new Point(0,0);
        House firstHouse = new House(firstHousePoint, firstSim);
        firstSim.setCurrentHouse(firstHouse);
        firstSim.setCurrentRoom(firstHouse.getMainRoom());
        firstSim.setCurrentPosition(new Point(0, 0));
        firstSim.setRumah(firstHouse);
        currentSim = firstSim;
    }

    public void displayTime() {
        boolean validpos = true;
        if (getCurrentSim().getCurrentRoom().getObjectGrid().objectOnPosition(getCurrentSim().getCurrentPoisition()) == null) {
            validpos = false;
        } else {
            FurnitureObject furniture = (FurnitureObject) getCurrentSim().getCurrentRoom().getObjectGrid().objectOnPosition(getCurrentSim().getCurrentPoisition());
            if (!(furniture.getFurniture().getAction().equals("LookAtClock"))) {
                validpos = false;
            }
        }
        if (!validpos) {
            System.out.println("You are not on the correct object!");
        } else {
        int totalSeconds = clock.getSeconds();
        int totalDays = clock.getDays();
        System.out.println("Remaining time: " + (720 - (totalSeconds % 720)));
        System.out.println("---");
        if (currentPassiveActions.containsKey(currentSim)) {
            System.out.println("Aksi-aksi yang sedang berlangsung:");
            List<SimPassiveAction> simPassiveActions = currentPassiveActions.get(currentSim);
            for (SimPassiveAction passiveAction : simPassiveActions) {
                System.out.println(passiveAction.getClass().getSimpleName() + " " + (passiveAction.getEndTime() - Clock.getInstance().getSeconds()));
            }
        } else {
            System.out.println("Tidak ada aksi yang sedang berlangsung.");
        }
        }
    }
}
