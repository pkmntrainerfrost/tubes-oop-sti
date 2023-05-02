import java.util.*;

public class ReadBook extends SimActiveAction {

    public void begin(Sim sim){
        System.out.println("Masukkan durasi: ");
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
    }

    public void end(Sim sim) {
        if (getSim().getCurrentRoom().getItemListInRoom().contains("Rak buku")){
            int time = getDuration()/60;
            getSim().setMood(getSim().getMood() + time * 6);
            getSim().setKekenyangan(getSim().getKekenyangan() - time * 6);
        }
    }

}