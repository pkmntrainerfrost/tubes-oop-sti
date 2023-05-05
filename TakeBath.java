public class TakeBath extends SimActiveAction {

    public void begin(Sim sim) {
        
    }

    public void end(Sim sim) {
        int time = getDuration()/240;
        sim.setMood(sim.getMood() + time * 10);
        sim.setKesehatan(sim.getKesehatan() + time * 10);
    }

}