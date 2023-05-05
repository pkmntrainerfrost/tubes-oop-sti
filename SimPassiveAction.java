import java.util.EventListener;

public abstract class SimPassiveAction implements SimAction {    
    
    private int duration;
    private int endTime;
    private boolean finished = false;

    public void execute(Sim sim) {
        begin(sim);
        new Thread(() -> {
            process(sim);
            end(sim);
        }).start();
    }

    public abstract void begin(Sim sim);

    public void process(Sim sim) {

        endTime = Clock.getInstance().getSeconds() + duration;

        Game.getInstance().getPassiveAction().add(this);

        Clock.getInstance().startClock();
        
        int currentTime = Clock.getInstance().getSeconds();
            
        while (currentTime < endTime) {
            currentTime = Clock.getInstance().getSeconds();
        }
        finished = true;

        if (Game.getInstance().getPassiveAction().isEmpty()) {
            Clock.getInstance().stopClock();
        }

    }

    public abstract void end(Sim sim);

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
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

/*
class addItemToRoom extends SimPassiveAction{
    private Room room;
    private FurnitureObject furniture;
    private Sim sim;

    public Sim getSim() {
        return sim;
    }

    public addItemToRoom(Sim sim, Room room, FurnitureType furniture) {
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
*/