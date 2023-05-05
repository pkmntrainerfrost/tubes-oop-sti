public class Work extends SimActiveAction {

    public void begin(Sim sim) {
        
    }
    
    public void end(Sim sim) {

        sim.getjob().getSalary();
        sim.setWorkSeconds(sim.getWorkCycle() + this.getDuration());

        if (sim.getWorkCycle() >= 240) {
            int wage = sim.getPekerjaan().getSalary();
            sim.setUang(sim.getUang() + wage);
            if (sim.getPekerjaan().getName().equals("Asisten Labpro")) {
                
            }
        }

        /*
        if (this.sim.getWorkSeconds() >= 240) {
            if (this.sim.getjob().getJobName().equals("MagicClown")){
                this.sim.getjob().addGaji(15);
            } else if (this.sim.getjob().getJobName().equals("Chef")){
                this.sim.getjob().addGaji(30);
            } else if (this.sim.getjob().getJobName().equals("Police")){
                this.sim.getjob().addGaji(35);
            } else if (this.sim.getjob().getJobName().equals("Programmer")){
                this.sim.getjob().addGaji(45);
            } else if (this.sim.getjob().getJobName().equals("Doctor")){
                this.sim.getjob().addGaji(50);
            }
            
        }
        */
    }

}