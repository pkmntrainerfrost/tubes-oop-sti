import java.util.*;

public class Work extends SimActiveAction {

    public void begin(Sim sim) {
        System.out.println("=======================");
        System.out.print("input work duration: ");

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
        System.out.println("=======================");
        this.setDuration(duration);
    }
    
    public void end(Sim sim) {
        sim.setWorkCycle(sim.getWorkCycle() + this.getDuration());
        
        int time = this.getDuration() / 30;
        sim.setKekenyangan(sim.getKekenyangan() + (time * 10));
        sim.setMood(sim.getMood() + (time * 10));

        /* jika kerja diatas 4 menit */
        if (sim.getWorkCycle() >= 240) { 
            int wage = sim.getPekerjaan().getSalary();
            sim.setUang(sim.getUang() + wage);
            
            System.out.println("===================================");
            System.out.println(sim.getName() + " bekerja sebagai " + sim.getPekerjaan().getName());
            System.out.println("Uang " + sim.getName() + " bertambah menjadi " + sim.getUang());
            System.out.println("Kekenyangan " + sim.getName() + " bertambah menjadi " + sim.getKekenyangan());
            System.out.println("Mood " + sim.getName() + " bertambah menjadi " + sim.getMood());
            System.out.println("===================================");
        }
    }
}