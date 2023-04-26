public class Work extends SimActiveAction {

    public Work(Sim sim, int duration) {
        super(sim, duration);
    }
    
    public void finish() {
        this.getSim().setWorkSeconds(this.getSim().getWorkSeconds() + this.getDuration());
        if (this.getSim().getWorkSeconds() >= 240) {
        
        }
    }
    
}