import java.lang.Math;
import java.util.*;

public class Visit extends SimActiveAction {

    private House houseToVisit;

    public void begin(Sim sim) {
        System.out.println("=======================");
        System.out.print("input visit duration: ");

        /* scanner and set duration + set housename to visit */
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();

        System.out.println("input house's name to visit: ");
        String houseName = scan.next();

        System.out.println("=======================");
        this.setDuration(duration);
    }

    public void end(Sim sim) {
        sim.setCurrentHouse(houseToVisit);
        // asuuuuuuuuuuuuuuuu
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
