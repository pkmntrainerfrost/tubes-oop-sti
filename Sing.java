import java.util.*;

public class Sing extends SimActiveAction {

    public void begin(Sim sim){
        System.out.println("=======================");
        System.out.print("input sing duration: ");

        CommandLine cli = new CommandLine();

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        String inputDuration = scan.nextLine();
        System.out.println("=======================");

        while (!cli.validateInputInteger(inputDuration)) {
            System.out.println("=======================");
            System.out.print("input sing duration: ");
            inputDuration = scan.nextLine();
        }
        int duration = Integer.parseInt(inputDuration);
        System.out.println("in duration valid!");
        this.setDuration(duration);
    }
 
    public void end(Sim sim) { 
        int time = this.getDuration()/60; 
        sim.setMood(sim.getMood() + time * 5); 
        sim.setKekenyangan(sim.getKekenyangan() - time * 5);
    }
}