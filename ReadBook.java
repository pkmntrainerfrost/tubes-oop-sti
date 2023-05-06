import java.util.*;

public class ReadBook extends SimActiveAction {

    public void begin(Sim sim){
        System.out.println("=======================");
        System.out.print("input readbook duration: ");

        CommandLine cli = new CommandLine();

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        String inputDuration = scan.nextLine();
        System.out.println("=======================");

        while (!cli.validateInputInteger(inputDuration)) {
            System.out.println("=======================");
            System.out.print("input readbook duration: ");
            inputDuration = scan.nextLine();
        }
        int duration = Integer.parseInt(inputDuration);
        System.out.println("readbook duration valid!");
        this.setDuration(duration);
    }

    public void end(Sim sim) {
            /* efek dari meditation berlaku per 60 detik sekali */
            int duration = this.getDuration()/60;
            sim.setMood(sim.getMood() + (duration * 6));                  // sim akan bertambah moodnya sebesar +6 per 60 detik
            sim.setKekenyangan(sim.getKekenyangan() - (duration * 6));    // sim akan berkurang kekenyangannya sebesar -6 per 60 detik
    }

}