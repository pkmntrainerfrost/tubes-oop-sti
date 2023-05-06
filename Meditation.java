import java.util.*;

public class Meditation extends SimActiveAction {
    public void begin(Sim sim){
        System.out.println("=======================");
        System.out.print("input meditation duration: ");

        CommandLine cli = new CommandLine();

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        String inputDuration = scan.nextLine();
        System.out.println("=======================");

        while (!cli.validateInputInteger(inputDuration)) {
            System.out.println("=======================");
            System.out.print("input meditation duration: ");
            inputDuration = scan.nextLine();
        }
        int duration = Integer.parseInt(inputDuration);
        System.out.println("meditation duration valid!");
        this.setDuration(duration);
    }

    public void end(Sim sim) {
            /* efek dari meditation berlaku per 10 detik sekali */
            int time = this.getDuration() / 10;      
            sim.setMood(sim.getMood() + (time * 5));              // sim akan bertambah moodnya sebesar +5 per 10 detik
            sim.setKesehatan(sim.getKesehatan() + (time * 5));    // sim akan bertambah kesehatannya sebesar +5 per 10 detik
    }

}