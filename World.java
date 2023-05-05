import java.util.*;

public class World {

    private Grid houseGrid;

    private static World instance = new World();

    private World() {
        houseGrid = new Grid(64,64);
    }

    public Grid getHouseGrid() {
        return houseGrid;
    }

    public void addHouseToWorld(House house){
        try {
            houseGrid.addObject(house);
        } catch (PositionOccupiedException | PositionOutOfBoundsException e) {

        }
    }

    public static World getInstance() {
        return instance;
    }

}

/*
public class World {

    // Implementasi World menggunakan Design Pattern Singleton
    private List<House> houseList;
    private ArrayList<SimAction> actionList;
    private Grid houseGrid;
    private Mediator actionMediator;
    private Mediator simMediator;
    // private static World instance = new World();
    private Scanner sc = new Scanner(System.in);
    private Sim currentSim;
    private House currentHouse;
    private int seconds;
    private EventManager events;

    public World() {
        houseGrid = new Grid(64,64);
        actionList = new ArrayList<>();
        houseList = new ArrayList<>();
        Point pAwal = new Point(0, 0);
        currentHouse = new House(pAwal, this, currentSim, "home");
        addHouseToWorld(currentHouse);
        actionMediator = Mediator.getInstance();
        simMediator = Mediator.getInstance();

        System.out.println("Write your character's name: ");
        String name = sc.nextLine();
        currentSim = new Sim(name);
    }

    // public static World getInstance() {
    //     return instance;
    // }

    // public void resetWorld() {
    //     instance = new World(); // Menginstansiasi ulang instance agar bernilai baru
    // }

    public ArrayList<SimAction> getActionList() {
        return actionList;
    }

    

    public void addSim(String name) {
        Sim sim = new Sim(name);
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

    public Mediator getMediator(String param){
        if (param.equals("sim")){
            return simMediator;
        }else if (param.equals("sim")){
            return actionMediator;
        }else{
            return null;
        }
    }
    public int getSeconds() {
        return seconds;
    }

    public EventManager getEvents() {
        return events;
    }

    public Sim getCurrentSim(){
        return currentSim;
    }

}
*/