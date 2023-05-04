public class Work extends SimActiveAction {

    public void begin(Sim sim) {
        
    }
    
    public void end(Sim sim) {

        getSim().getjob().getSalary();
        this.getSim().setWorkSeconds(this.getSim().getWorkSeconds() + this.getDuration());

        /*
        if (this.getSim().getWorkSeconds() >= 240) {
            if (this.getSim().getjob().getJobName().equals("MagicClown")){
                this.getSim().getjob().addGaji(15);
            } else if (this.getSim().getjob().getJobName().equals("Chef")){
                this.getSim().getjob().addGaji(30);
            } else if (this.getSim().getjob().getJobName().equals("Police")){
                this.getSim().getjob().addGaji(35);
            } else if (this.getSim().getjob().getJobName().equals("Programmer")){
                this.getSim().getjob().addGaji(45);
            } else if (this.getSim().getjob().getJobName().equals("Doctor")){
                this.getSim().getjob().addGaji(50);
            }
            
        }
        */
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}