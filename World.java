import java.util.*;

public class World {

    // Implementasi World menggunakan Design Pattern Singleton

    private List<Sim> simList;
    private List<SimAction> actionList;

    private Grid houseGrid;

    private SimActionMediator actionMediator;

    private static World instance = new World();

    private World() {
        houseGrid = new Grid(64,64);
        simList = new ArrayList<>();
        actionList = new ArrayList<>();
        actionMediator = SimActionMediator.getInstance();
    }

    public static World getInstance() {
        return instance;
    }

    public void resetWorld() {
        instance = new World();
    }

    public List<SimAction> getActionList() {
        return actionList;
    }
}
