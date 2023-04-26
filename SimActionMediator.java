import java.util.*;

public class SimActionMediator {

    /* Menggunakan design pattern singleton + modifier mediator (aslinya interface) */

    private World world;
    private Clock clock;
    
    private static SimActionMediator instance = new SimActionMediator();

    private SimActionMediator() {
        world = World.getInstance();
        clock = Clock.getInstance();
    }

    public static SimActionMediator getInstance() {
        return instance;
    } 

    public void addAction(SimAction action) {
        List<SimAction> actionList = world.getActionList();
        actionList.add(action);
        if (!(clock.getRunning())) {
            clock.startClock();
        }
    }

    public void removeAction(SimAction action) {
        List<SimAction> actionList = world.getActionList();
        actionList.remove(action);
        if (actionList.isEmpty()) {
            clock.stopClock();
        }
    }
    
}
