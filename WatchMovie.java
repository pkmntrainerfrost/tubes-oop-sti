public class WatchMovie extends SimActiveAction {

    public void begin(Sim sim){
        /* ini gaperlu inputan */
    }

    public void end(Sim sim) {
        sim.setMood(sim.getMood() + (10));                    // sim akan bertambah moodnya sebesar +10              
        sim.setKesehatan(sim.getKesehatan() - (4));           // sim akan berkurang kesehatannya sebesar -4
        sim.setKekenyangan(sim.getKekenyangan() - (4));       // sim akan berkurang kekenyangannya sebesar -4
    }

}