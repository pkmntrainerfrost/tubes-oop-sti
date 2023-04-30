public class ReadBook extends SimActiveAction {

    public ReadBook(Sim sim, int duration) {
        super(sim, duration);
    }

    public ReadBook(Sim sim) {
        super(sim);
    }

    public void finish() {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Rak buku")){
            int time = getDuration()/60;
            getSim().setMood(getSim().getMood() + time * 6);
            getSim().setKekenyangan(getSim().getKekenyangan() - time * 6);
        }
    }

}