import java.util.*;

public class Sing extends SimActiveAction {

    public void begin(Sim sim){
        boolean validpos = true;
        if (sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition()) == null) {
            validpos = false;
        } else {
            FurnitureObject furniture = (FurnitureObject) sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition());
            if (!(furniture.getFurniture().getAction().equals("Sing"))) {
                validpos = false;
            }
        }
        if (!validpos) {
            System.out.println("You are not on the correct object!");
            setCancelled(true);
        } else {
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
        System.out.println("sing duration valid!");
        this.setDuration(duration);
        }
    }
 
    public void end(Sim sim) { 
        int time = this.getDuration()/60; 
        sim.setMood(sim.getMood() + time * 5); 
        sim.setKekenyangan(sim.getKekenyangan() - time * 5);
    }
}