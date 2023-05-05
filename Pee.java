public class Pee extends SimActiveAction {
    
    public void begin(Sim sim) {
        
    }

    public void end(Sim sim) {

        sim.setKekenyangan(sim.getKekenyangan() - (20));
        sim.setMood(sim.getMood() + (10));

    }

    /*
    // "Berlaku 4 menitnya setiap setelah makan" -> asumsi tidak siklus
    public void didntPee() {
        if (getEatTimeFinished() > 240){ //4 menit
            System.out.println(sim.getName() + " hasn't peed yet!");
            sim.setKesehatan(sim.getKesehatan() - 5);
            sim.setMood(sim.getMood() - 5 );
        }
    }
    */

}