import java.util.*;

public class ReadBook extends SimActiveAction {

    public void begin(Sim sim){
        System.out.print("input readbook duration: ");
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
        setDuration(duration);
    }

    public void end(Sim sim) {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Rak buku")){
            int duration = getDuration()/60;
            getSim().setMood(getSim().getMood() + (time * 6));
            getSim().setKekenyangan(getSim().getKekenyangan() - (time * 6));
        }
    }
}