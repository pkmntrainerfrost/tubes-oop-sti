public class ThrowRubbish extends SimActiveAction {
    public void begin(Sim sim){

    }

    public void end(Sim sim) {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("RubbishBin")){
            int time = 2;
            getSim().setMood()
            getSim().setMood(getSim().getMood() + time * 5);
            getSim().setKesehatan(getSim().getKesehatan() - time * 5);
        }
    }
}
