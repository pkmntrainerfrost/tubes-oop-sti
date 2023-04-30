public class Drink extends SimActiveAction {
    public Drink(int duration, Sim sim) {
        super(sim, duration);
    }

    public Drink(Sim sim) {
        super(sim);
    }

    public void finish() {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("DrinkingGlass")){
            int time = getDuration()/2;
            getSim().setKesehatan(getSim().getKesehatan() + time * 2);
            getSim().setKekenyangan(getSim().getKekenyangan() + time * 1);
        }
    }
}