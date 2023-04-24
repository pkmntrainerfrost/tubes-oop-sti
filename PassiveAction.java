import java.util.EventListener;

public abstract class PassiveAction extends Action implements EventListener {    

    private int timePassed = 0;
    private int startTime = World.getInstance().getSeconds();

    public PassiveAction(Sim sim) {
        super(sim);
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
        super(1080,sim);
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

    public addItemToRoom(Sim sim, Room room, Stuffs stuff) {
        super(sim);
        //TODO Auto-generated constructor stub
        this.stuff = stuff;
        this.room = room;
    }

    @Override
    public void acted() {
        if (stuff.getCategory().equals("Stuffs")){
            if (room.getAvailableSpace() > (stuff.getStuffLength() * stuff.getStuffWidth() + room.getLength()) || room.getAvailableSpace() > (stuff.getStuffLength() * stuff.getStuffWidth() + room.getHeight())){
                room.getItemListInRoom().add(stuff);
                getSim().getSimInventory().removeItem(stuff.getItemName(), 1) {

                }
            }
        }
    }

    
}