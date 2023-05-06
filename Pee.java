import java.util.*;

public class Pee extends SimActiveAction {
    
    public void begin(Sim sim) {
        boolean validpos = true;
        if (sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition()) == null) {
            validpos = false;
        } else {
            FurnitureObject furniture = (FurnitureObject) sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition());
            if (!(furniture.getFurniture().getAction().equals("Pee"))) {
                validpos = false;
            }
        }
        if (!validpos) {
            System.out.println("You are not on the correct object!");
            setCancelled(true);
        } else {
        this.setDuration(10);
        }
    }

    public void end(Sim sim) {

        sim.setKekenyangan(sim.getKekenyangan() - (20));
        sim.setMood(sim.getMood() + (10));

    }

    /*
    // "Berlaku 4 menitnya setiap setelah makan" -> asumsi tidak siklus
    public void didntPee() {
        if (getEatTimeFinished() > 240){ //4 menit
            System.out.println(sim.getName() + " hasn't peed yet!");
            sim.setKesehatan(sim.getKesehatan() - 5);
            sim.setMood(sim.getMood() - 5 );
        }
    }
    */

}