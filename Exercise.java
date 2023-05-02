public class Exercise extends SimActiveAction {
    public void begin(){

    }

    @Override
    public void end() {
        int time = getDuration()/20;
        getSim().setKesehatan(getSim().getKesehatan() + (time * 5));
        getSim().setKekenyangan(getSim().getKekenyangan() - (time * 5));
        getSim().setMood(getSim().getMood() + (time * 10));
    }
}