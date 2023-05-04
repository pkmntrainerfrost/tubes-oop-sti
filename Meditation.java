import java.util.*;

public class Meditation extends SimActiveAction {
    public void begin(Sim sim){
        Scanner scan = new Scanner(System.in);
        System.out.print("input meditation duration: ");
        int duration = scan.nextInt();
        setDuration(duration);
    }

    public void finish() {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Mattress")){
            /* duration  */
            int duration = getDuration()/10;      
            getSim().setMood(getSim().getMood() + time * 5);
            getSim().setKesehatan(getSim().getKesehatan() + time * 5);
        }
    }
}