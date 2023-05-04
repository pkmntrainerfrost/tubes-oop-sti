public class Drink extends SimActiveAction {
    public void begin(Sim sim) {

    }

    public void end(Sim sim) {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("DrinkingGlass")){
            /* waktu yang dibutuhkan untuk watchmovie tidak dipermasalahkan */
            getSim().setKesehatan(getSim().getKesehatan() + (2));     // sim akan bertambah kesehatannya sebesar +2
            getSim().setKekenyangan(getSim().getKekenyangan() + (1)); // sim akan bertambah kekenyangannya sebesar +1
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}