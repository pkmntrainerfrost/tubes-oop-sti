import java.util.*;

public class Meditation extends SimActiveAction {
    public void begin(Sim sim){
        System.out.print("input meditation duration: ");

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
        setDuration(duration);
    }

    public void end(Sim sim) {
            /* efek dari meditation berlaku per 10 detik sekali */
            int duration = getDuration()/10;      
            sim.setMood(sim.getMood() + (duration * 5));              // sim akan bertambah moodnya sebesar +5 per 10 detik
            sim.setKesehatan(sim.getKesehatan() + (duration * 5));    // sim akan bertambah kesehatannya sebesar +5 per 10 detik
    }

}