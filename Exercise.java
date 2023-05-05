import java.util.*;

public class Exercise extends SimActiveAction {

    public void begin(Sim sim){
        System.out.println("=======================");
        System.out.print("input exercise duration: ");

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
        System.out.println("=======================");
        this.setDuration(duration);
    }

    public void end(Sim sim) {
        int time = this.getDuration()/20;
        sim.setKesehatan(sim.getKesehatan() + (time * 5));
        sim.setKekenyangan(sim.getKekenyangan() - (time * 5));
        sim.setMood(sim.getMood() + (time * 10));
    }
}