import java.util.*;

public class World {

    // Implementasi World menggunakan Design Pattern Singleton

    private List<Sim> simList;
    private List<Action> actionList;

    private Grid houseGrid;

    private ActionMediator actionMediator;

    private static World instance = new World();

    private World() {
        houseGrid = new Grid(64,64);
        simList = new ArrayList<>();
        actionList = new ActionList<>();
        actionMediator = actionMediator.getInstance();
    }

    public static World getInstance() {
        return instance;
    }

    public void resetWorld() {
        instance = newWorld;
    }

    public List<Action> getActionList() {
        return actionList;
    }
}
