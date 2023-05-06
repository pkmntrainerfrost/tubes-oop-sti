public class WatchMovie extends SimActiveAction {

    public void begin(Sim sim){
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
            setDuration(60);
        }
    }

    public void end(Sim sim) {
        sim.setMood(sim.getMood() + (10));                    // sim akan bertambah moodnya sebesar +10              
        sim.setKesehatan(sim.getKesehatan() - (4));           // sim akan berkurang kesehatannya sebesar -4
        sim.setKekenyangan(sim.getKekenyangan() - (4));       // sim akan berkurang kekenyangannya sebesar -4
    }

}