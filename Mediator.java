import java.util.*;

import javax.swing.ActionMap;

public class Mediator {

    /* Menggunakan design pattern singleton + modified mediator (aslinya interface/abstract class, tapi karena emang cuman satu yaudah pake class aja) */

    private Clock clock;

    private static ArrayList<Sim> simList = new ArrayList<Sim>();
    private Map<Sim,SimAction> simActionMap;
    
    private static Mediator instance = new Mediator();

    private Mediator() {
        clock = Clock.getInstance();
    }

    public static Mediator getInstance() {
        return instance;
    } 

    public void addAction(Sim sim, SimAction action) {
        simActionMap.put(sim, action);
        if (!(clock.getRunning())) {
            clock.startClock();
        }
    }

    public void removeAction(World world, Sim sim, SimAction action) {
        ArrayList<SimAction> actionList = world.getActionList();
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

    public static ArrayList<Sim> getSimList(){
        return simList;
    }

    public Map<Sim,SimAction> getActionList(){
        return simActionMap;
    }
}
