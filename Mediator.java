import java.util.*;

public class Mediator {

    /* Menggunakan design pattern singleton + modified mediator (aslinya interface/abstract class, tapi karena emang cuman satu yaudah pake class aja) */

    private World world;
    private Clock clock;

    private List<Sim> simList;
    private Map<Sim,SimAction> simActionMap;
    
    private static Mediator instance = new Mediator();

    private Mediator() {
        world = World.getInstance();
        clock = Clock.getInstance();
    }

    public static Mediator getInstance() {
        return instance;
    } 

    public void addAction(Sim sim, SimAction action) {
        List<SimAction> actionList = world.getActionList();
        actionList.add(action);
        if (!(clock.getRunning())) {
            clock.startClock();
        }
    }

    public void removeAction(Sim sim, SimAction action) {
        List<SimAction> actionList = world.getActionList();
        actionList.remove(action);
        if (actionList.isEmpty()) {
            clock.stopClock();
        }
    }

    public void addSim(Sim sim) {
        simList.add(sim);
    }

    public void removeSim(Sim sim) {
        simList.remove(sim);
    }
    
}
