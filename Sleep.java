import java.util.*;

public class Sleep extends SimActiveAction {
    
    public void begin(Sim sim){
        System.out.println("=======================");
        System.out.print("input work duration: ");

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
        System.out.println("=======================");
        this.setDuration(duration);
    }

    /* ini belum ada kalau engga dilakukan */
    public void end(Sim sim) {
        int time = getDuration()/240;
        sim.setMood(sim.getMood() + (time * 30));
        sim.setKesehatan(sim.getKesehatan() + (time * 20));
    }
}