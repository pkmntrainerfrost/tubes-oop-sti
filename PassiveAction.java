import java.util.EventListener;

public abstract class PassiveAction extends Action implements EventListener {    

    private int timePassed = 0;
    private int startTime;
    private int duration;

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public PassiveAction(Sim sim, int duration) {
        super(sim);
        startTime = World.getInstance().getSeconds();
        setDuration(duration);
    }

    public abstract void acted();

    public void update(String eventType) {
        timePassed += World.getInstance().getSeconds() - startTime;
        if (timePassed >= getDuration()) {
            acted();
            World.getInstance().getEvents().unsubscribe(eventType, this);
        }
    }
    
}

class HouseUpgrade extends PassiveAction {

    private Room room;

    public HouseUpgrade(Sim sim, Room room) {
        super(sim, 1080);
        this.room = room;
    }

    public void acted() {
        room.setFinished(true);
    }

}

// belom kelar
class addItemToRoom extends PassiveAction{
    private Room room;
    private Stuffs stuff;
    private Sim sim;

    public Sim getSim() {
        return sim;
    }

    public addItemToRoom(Sim sim, Room room, Stuffs stuff) {
        super(sim, 0);
        //TODO Auto-generated constructor stub
        this.stuff = stuff;
        this.room = room;
        this.sim = sim;
    }

    @Override
    public void acted() {
        if (stuff.getCategory().equals("Stuffs")){
            if (room.getAvailableSpace() > (stuff.getStuffLength() * stuff.getStuffWidth() + room.getLength()) || room.getAvailableSpace() > (stuff.getStuffLength() * stuff.getStuffWidth() + room.getHeight())){
                room.getItemListInRoom().add(stuff);
                getSim().getSimInventory().removeItem(stuff.getItemName(), 1);
            }
        }
    }

    
}