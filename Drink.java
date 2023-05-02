public class Drink extends SimActiveAction {
    public void begin(){

    }

    public void end() {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("DrinkingGlass")){
            int time = getDuration()/2;
            getSim().setKesehatan(getSim().getKesehatan() + time * 2);
            getSim().setKekenyangan(getSim().getKekenyangan() + time * 1);
        }
    }
}