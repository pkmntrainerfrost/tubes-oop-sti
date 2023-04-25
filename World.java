import java.util.*;

public class World {

    // Implementasi World menggunakan Design Pattern Singleton

    private List<Sim> simList;
    private List<ActiveAction> activeActionList;
    private List<PassiveAction> passiveActionList;

    private Grid houseGrid;
    private Clock clock;

    private static World instance = new World();

    private World() {
        clock = Clock.getInstance();
        houseGrid = new Grid(64,64);
        simList = new ArrayList<>();
        activeActionList = new ArrayList<>();
        passiveActionList = new ArrayList<>();
    }

    public static World getInstance() {
        return instance;
    }

    public void resetWorld() {
        instance = newWorld;
    }

}
