public class Drink extends SimActiveAction {
    public void begin(){

    }

    public void end() {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("DrinkingGlass")){
            /* waktu yang dibutuhkan untuk watchmovie tidak dipermasalahkan */
            getSim().setKesehatan(getSim().getKesehatan() + (2));     // sim akan bertambah kesehatannya sebesar +2
            getSim().setKekenyangan(getSim().getKekenyangan() + (1)); // sim akan bertambah kekenyangannya sebesar +1
        }
    }
}