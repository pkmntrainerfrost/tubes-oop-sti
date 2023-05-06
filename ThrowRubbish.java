public class ThrowRubbish extends SimActiveAction {
    
    public void begin(Sim sim) {
        boolean validpos = true;
        if (sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition()) == null) {
            validpos = false;
        } else {
            FurnitureObject furniture = (FurnitureObject) sim.getCurrentRoom().getObjectGrid().objectOnPosition(sim.getCurrentPoisition());
            if (!(furniture.getFurniture().getAction().equals("Cook"))) {
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
        sim.setMood(sim.getMood() + (5));             // sim akan bertambah moodnya sebesar +5
        sim.setKesehatan(sim.getKesehatan() + (5));   // sim akan bertambah kesehatannya sebesar +5
    }


}
