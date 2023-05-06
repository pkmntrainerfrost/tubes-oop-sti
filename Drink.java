public class Drink extends SimActiveAction {

    public void begin(Sim sim) {
        /* ini gaperlu inputan */
        boolean validpos = true;
        if (sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition()) == null) {
            validpos = false;
        } else {
            FurnitureObject furniture = (FurnitureObject) sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition());
            if (!(furniture.getFurniture().getAction().equals("Drink"))) {
                validpos = false;
            }
        }
        if (!validpos) {
            System.out.println("You are not on the correct object!");
            setCancelled(true);
        } else {
            setDuration(2);
        }
    }   

    public void end(Sim sim) {
        sim.setKesehatan(sim.getKesehatan() + (2));
        sim.setKekenyangan(sim.getKekenyangan() + (1));
    }
}