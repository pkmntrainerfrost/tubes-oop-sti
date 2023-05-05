public class ThrowRubbish extends SimActiveAction {
    
    public void begin(Sim sim) {

    }

    public void end(Sim sim) {
            /* waktu yang dibutuhkan untuk throwrubbish tidak dipermasalahkan */
        sim.setMood(sim.getMood() + (5));             // sim akan bertambah moodnya sebesar +5
        sim.setKesehatan(sim.getKesehatan() + (5));   // sim akan bertambah kesehatannya sebesar +5
    }


}
