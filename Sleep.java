public class Sleep extends SimActiveAction {
    
    public void begin(Sim sim) {

    }

    @Override
    public void end(Sim sim) {
        int time = getDuration()/240;
        sim.setMood(sim.getMood() + (time * 30));
        sim.setKesehatan(sim.getKesehatan() + (time * 20));
    }
}