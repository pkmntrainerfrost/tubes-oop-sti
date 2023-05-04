public class ThrowRubbish extends SimActiveAction {
    public void begin(Sim sim) {

    }

    public void end(Sim sim) {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("RubbishBin")){
            /* waktu yang dibutuhkan untuk throwrubbish tidak dipermasalahkan */
            getSim().setMood(getSim().getMood() + (5));             // sim akan bertambah moodnya sebesar +5
            getSim().setKesehatan(getSim().getKesehatan() + (5));   // sim akan bertambah kesehatannya sebesar +5
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
