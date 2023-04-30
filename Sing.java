public class Sing extends SimActiveAction {
    public Sing(Sim sim, int duration) { 
        super(sim, duration); 
    } 
    public Sing(Sim sim) {
        super(sim);
    }
 
    public void finish() { 
        //benerin getter ada micnya, harusnya bisa sih
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Mic")){
            int time = getDuration()/60; 
            getSim().setMood(getSim().getMood() + time * 5); 
            getSim().setKekenyangan(getSim().getKekenyangan() - time * 5);

        }
    }

}