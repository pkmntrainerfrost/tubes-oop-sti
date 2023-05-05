import java.util.*;

public class Sing extends SimActiveAction {

    public void begin(Sim sim){
        System.out.println("=======================");
        System.out.print("input sing duration: ");

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
        System.out.println("=======================");
        this.setDuration(duration);
    }
 
    public void end(Sim sim) { 
        int time = this.getDuration()/60; 
        sim.setMood(sim.getMood() + time * 5); 
        sim.setKekenyangan(sim.getKekenyangan() - time * 5);
    }
}