public class WatchMovie extends SimActiveAction {
    public void begin(Sim sim){

    }

    public void end(Sim sim) {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Smart Television")){
            /* waktu yang dibutuhkan untuk watchmovie tidak dipermasalahkan */
            getSim().setMood(getSim().getMood() + (10));                    // sim akan bertambah moodnya sebesar +10              
            getSim().setKesehatan(getSim().getKesehatan() - (4));           // sim akan berkurang kesehatannya sebesar -4
            getSim().setKekenyangan(getSim().getKekenyangan() - (4));       // sim akan berkurang kekenyangannya sebesar -4
        }
    }
}