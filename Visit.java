import java.lang.Math;
import java.util.*;

public class Visit extends SimActiveAction {

    private House houseToVisit;
    private World world;

    public static void begin(Sim sim) {
        sim.setIsVisiting(true);
        System.out.println("=======================");

        /* scanner set housename to visit */
        Scanner scan = new Scanner(System.in);

        System.out.println("input house's name to visit: ");
        String houseToVisit = scan.nextLine();

        for(int i = 0; i < world.getHouseList().size(); i++){
            if(world.getHouseList().get(i).getHouseName().equals(houseToVisit)){
                System.out.println(sim.getName() + " is visiting " + houseToVisit);
            }
        }
    

        System.out.println("=======================");

        setDuration((int) Math.sqrt(sim.getCurrentHouse().getPoint().getX() - houseToVisit.getPoint().getX()) + (sim.getCurrentHouse().getPoint().getY()) - houseToVisit.getPoint().getY());
        
    }

    public static void end(Sim sim) {
        sim.setCurrentHouse(houseToVisit);
        sim.setIsVisiting(true);
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
