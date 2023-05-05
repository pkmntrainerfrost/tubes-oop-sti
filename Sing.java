public class Sing extends SimActiveAction {

    public void begin(Sim sim) {

    }
 
    public void end(Sim sim) { 

        int time = getDuration()/60; 
        sim.setMood(sim.getMood() + time * 5); 
        sim.setKekenyangan(sim.getKekenyangan() - time * 5);

    }

}