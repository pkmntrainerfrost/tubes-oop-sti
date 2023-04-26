import java.util.*;

public class ActionMediator {

    /* Menggunakan design pattern singleton + modifier mediator (aslinya interface) */

    private World world;
    private Clock clock;
    
    private static ActionMediator instance = new ActionMediator();

    private ActionMediator() {
        world = World.getInstance();
        clock = Clock.getInstance();
    }

    public static ActionMediator getInstance() {
        return instance;
    } 

    public void addAction(Action action) {
        List<Action> actionList = world.getActionList();
        actionList.add(action);
        if (!(clock.getRunning())) {
            clock.startClock();
        }
    }

    public void removeAction(Action action) {
        List<Action> actionList = world.getActionList();
        actionList.remove(action);
        if (actionList.isEmpty()) {
            clock.stopClock();
        }
    }
    
}
