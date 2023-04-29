import java.util.EventListener;

public abstract class SimPassiveAction implements EventListener, SimAction {    
    private int timePassed = 0;
    private int startTime;
    private int duration;
    private Sim sim;

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public SimPassiveAction(Sim sim, int duration) {
        this.sim = sim;
        startTime = World.getInstance().getSeconds();
        setDuration(duration);
    }

    public abstract void act();
    public abstract void finish();
    public Sim getSim() {
        return sim;
    }

    public void update(String eventType) {
        timePassed += World.getInstance().getSeconds() - startTime;
        if (timePassed >= getDuration()) {
            act();
            World.getInstance().getEvents().unsubscribe(eventType, this);
        }
    }
    
}

class HouseUpgrade extends SimPassiveAction {

    private Room room;

    public HouseUpgrade(Sim sim, Room room) {
        super(sim, 1080);
        this.room = room;
    }

    public void act() {
        room.setFinished(true);
    }

}

// belom kelar
class addItemToRoom extends SimPassiveAction{
    private Room room;
    private FurnitureObject furniture;
    private Sim sim;

    public Sim getSim() {
        return sim;
    }

    public addItemToRoom(Sim sim, Room room, FurnitureObject furniture) {
        super(sim, 0);
        //TODO Auto-generated constructor stub
        this.furniture = furniture;
        this.room = room;
        this.sim = sim;
    }

    @Override
    public void act() {
        if (furniture.getFurniture().getCategory().equals("Furniture")){
            if (room.getAvailableSpace() > (furniture.getFurniture().getFurnitureLength() * furniture.getFurnitureWidth() + room.getLength()) || room.getAvailableSpace() > (furniture.getFurnitureLength() * furniture.getFurnitureWidth() + room.getHeight())){
                room.getItemListInRoom().add(furniture);
                getSim().getSimInventory().removeItem(furniture.getFurniture().getItemName(), 1);
            }
        }
    }

    
}