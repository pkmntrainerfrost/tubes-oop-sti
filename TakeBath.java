import java.util.*;

public class TakeBath extends SimActiveAction {

    public void begin(Sim sim){
        System.out.println("=======================");
        System.out.print("input takebath duration: ");

        CommandLine cli = new CommandLine();

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        String inputDuration = scan.nextLine();
        System.out.println("=======================");

        while (!cli.validateInputInteger(inputDuration)) {
            System.out.println("=======================");
            System.out.print("input takebath duration: ");
            inputDuration = scan.nextLine();
        }
        int duration = Integer.parseInt(inputDuration);
        System.out.println("takebath duration valid!");
        this.setDuration(duration);
    }

    public void end(Sim sim) {
        int time = this.getDuration()/240;
        sim.setMood(sim.getMood() + time * 10);
        sim.setKesehatan(sim.getKesehatan() + time * 10);
    }

}