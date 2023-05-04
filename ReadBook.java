import java.util.*;

public class ReadBook extends SimActiveAction {

    public void begin(Sim sim){
        System.out.print("input readbook duration: ");

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
        setDuration(duration);
    }

    public void end(Sim sim) {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Rak buku")){
            /* efek dari meditation berlaku per 60 detik sekali */
            int duration = getDuration()/60;
            getSim().setMood(getSim().getMood() + (duration * 6));                  // sim akan bertambah moodnya sebesar +6 per 60 detik
            getSim().setKekenyangan(getSim().getKekenyangan() - (duration * 6));    // sim akan berkurang kekenyangannya sebesar -6 per 60 detik
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}