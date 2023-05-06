import java.lang.Math;
import java.util.*;

public class GoHome extends SimActiveAction {

    public void begin(Sim sim) {
        House houseToVisit = sim.getRumah(); 
        setDuration((int) Math.sqrt(sim.getCurrentHouse().getPoint().getX() - houseToVisit.getPoint().getX()) + (sim.getCurrentHouse().getPoint().getY()) - houseToVisit.getPoint().getY());
        
    }

    public void end(Sim sim) {
        sim.setCurrentHouse(sim.getRumah());
        sim.setIsVisiting(false);
    }

    /*
    public Visit(House houseToVisit, Sim sim){
        super(sim);
        // duration dalam menit
        this.houseToVisit =houseToVisit;
        this.duration = (int) Math.sqrt(sim.getSimPosition().getX() - houseToVisit.getPoint().getX()) + (sim.getSimPosition().getY() - houseToVisit.getPoint().getY());
        this.finished = false;
    }


    public int getDuration() {
        return duration;
    }

    public boolean getStatusFinish() {
        return finished;
    }

    @Override
    public void finish() {
        getSim().setSimPosition(houseToVisit.getPoint());
        int time = (getDuration() * 60)/30;
        getSim().setMood(getSim().getMood() + (time * 10));
        getSim().setKekenyangan(getSim().getKekenyangan() - (time * 10));
        finished = true;
        System.out.println("Sim is now in " + houseToVisit.getHouseName());
    }
    */
    
}
