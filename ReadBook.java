import java.util.*;

public class ReadBook extends SimActiveAction {

    public void begin(Sim sim){
        boolean validpos = true;
        if (sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition()) == null) {
            validpos = false;
        } else {
            FurnitureObject furniture = (FurnitureObject) sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition());
            if (!(furniture.getFurniture().getAction().equals("ReadBook"))) {
                validpos = false;
                
            }
        }
        if (!validpos) {
            System.out.println("You are not on the correct object!");
            setCancelled(true);
        } else {
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
    }

    public void end(Sim sim) {
            /* efek dari meditation berlaku per 60 detik sekali */
            int duration = this.getDuration()/60;
            sim.setMood(sim.getMood() + (duration * 6));                  // sim akan bertambah moodnya sebesar +6 per 60 detik
            sim.setKekenyangan(sim.getKekenyangan() - (duration * 6));    // sim akan berkurang kekenyangannya sebesar -6 per 60 detik
    }

}