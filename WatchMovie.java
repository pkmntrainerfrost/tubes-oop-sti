public class WatchMovie extends SimActiveAction {
    public void begin(Sim sim){

    }

    public void end(Sim sim) {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Smart Television")){
            int time = 2;
            getSim().setMood(getSim().getMood() + time * 5);
            getSim().setKesehatan(getSim().getKesehatan() - time * 2);
            getSim().setKekenyangan(getSim().getKekenyangan() - time * 2);
        }
    }
}