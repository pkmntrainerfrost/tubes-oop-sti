import java.util.*;

public class Sleep extends SimActiveAction {
    
    public void begin(Sim sim){
        System.out.println("=======================");
        System.out.print("input sleep duration: ");

        CommandLine cli = new CommandLine();

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        String inputDuration = scan.nextLine();
        System.out.println("=======================");

        while (!cli.validateInputInteger(inputDuration)) {
            System.out.println("=======================");
            System.out.print("input sleep duration: ");
            inputDuration = scan.nextLine();
        }
        int duration = Integer.parseInt(inputDuration);
        System.out.println("sleep duration valid!");
        this.setDuration(duration);
    }

    /* ini belum ada kalau engga dilakukan */
    public void end(Sim sim) {
        int time = getDuration()/240;
        sim.setMood(sim.getMood() + (time * 30));
        sim.setKesehatan(sim.getKesehatan() + (time * 20));
    }
}