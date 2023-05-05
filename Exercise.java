public class Exercise extends SimActiveAction {

    public void begin(Sim sim){

    }

    @Override
    public void end(Sim sim) {
        int time = getDuration()/20;
        sim.setKesehatan(sim.getKesehatan() + (time * 5));
        sim.setKekenyangan(sim.getKekenyangan() - (time * 5));
        sim.setMood(sim.getMood() + (time * 10));
    }
}