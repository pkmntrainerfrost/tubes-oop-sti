public class Drink extends SimActiveAction {

    public void begin(Sim sim) {
        /* ini gaperlu inputan */
    }   

    public void end(Sim sim) {
        sim.setKesehatan(sim.getKesehatan() + (2));
        sim.setKekenyangan(sim.getKekenyangan() + (1));
    }
}