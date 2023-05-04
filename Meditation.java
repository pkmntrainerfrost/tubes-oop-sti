import java.util.*;

public class Meditation extends SimActiveAction {
    public void begin(Sim sim){
        System.out.print("input meditation duration: ");

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
        setDuration(duration);
    }

    public void end(Sim sim) {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Mattress")){
            /* efek dari meditation berlaku per 10 detik sekali */
            int duration = getDuration()/10;      
            getSim().setMood(getSim().getMood() + (duration * 5));              // sim akan bertambah moodnya sebesar +5 per 10 detik
            getSim().setKesehatan(getSim().getKesehatan() + (duration * 5));    // sim akan bertambah kesehatannya sebesar +5 per 10 detik
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}