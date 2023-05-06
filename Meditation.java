import java.util.*;

public class Meditation extends SimActiveAction {
    public void begin(Sim sim){
        boolean validpos = true;
        if (sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition()) == null) {
            validpos = false;
        } else {
            FurnitureObject furniture = (FurnitureObject) sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition());
            if (!(furniture.getFurniture().getAction().equals("Meditation"))) {
                validpos = false;
            }
        }
        if (!validpos) {
            System.out.println("You are not on the correct object!");
            setCancelled(true);
        } else {
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
    }

    public void end(Sim sim) {
            /* efek dari meditation berlaku per 10 detik sekali */
            int time = this.getDuration() / 10;      
            sim.setMood(sim.getMood() + (time * 5));              // sim akan bertambah moodnya sebesar +5 per 10 detik
            sim.setKesehatan(sim.getKesehatan() + (time * 5));    // sim akan bertambah kesehatannya sebesar +5 per 10 detik
    }

}