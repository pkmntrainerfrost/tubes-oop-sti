import java.util.*;

public class TakeBath extends SimActiveAction {

    public void begin(Sim sim){
        System.out.println("=======================");
        System.out.print("input takebath duration: ");

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
        System.out.println("=======================");
        this.setDuration(duration);
    }

    public void end(Sim sim) {
        int time = this.getDuration()/240;
        sim.setMood(sim.getMood() + time * 10);
        sim.setKesehatan(sim.getKesehatan() + time * 10);
    }

}