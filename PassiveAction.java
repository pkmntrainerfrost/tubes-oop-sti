public abstract class PassiveAction extends Action implements EventListener {    

    private int timePassed = 0;
    private int startTime = World.getInstance().getSeconds();

    public PassiveAction(int duration, Sim sim) {
        super(duration,sim);
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
