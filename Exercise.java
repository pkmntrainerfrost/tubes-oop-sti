import java.util.*;

public class Exercise extends SimActiveAction {

    public void begin(Sim sim){
        System.out.println("=======================");
        System.out.print("input exercise duration: ");

        CommandLine cli = new CommandLine();

        /* scanner and set duration */
        Scanner scan = new Scanner(System.in);
        String inputDuration = scan.nextLine();
        System.out.println("=======================");

        while (!cli.validateInputInteger(inputDuration)) {
            System.out.println("=======================");
            System.out.print("input exercise duration: ");
            inputDuration = scan.nextLine();
        }
        int duration = Integer.parseInt(inputDuration);
        System.out.println("exercise duration valid!");
        this.setDuration(duration);
    }

    public void end(Sim sim) {
        int time = this.getDuration()/20;
        sim.setKesehatan(sim.getKesehatan() + (time * 5));
        sim.setKekenyangan(sim.getKekenyangan() - (time * 5));
        sim.setMood(sim.getMood() + (time * 10));
    }
}

/*
 input nama barang + letak, dicek valid atau engga sama isi dari inventory item, jika dia ga valid lempar ke catch, 
 jika valid, dicek apakah tipenya furniture atau bukan, jika bukan lempar lagi,
 jika valid, dicek apakah letaknya tersedia di room, jika tidak lempar lagi,
 jika valid, barang di inventory di kurangin quantitynya, lakukan setpoint untuk memberi tau bahwa letak tersebut sudah ada barang
 tampilkan pesan berhasil di pasang.
 */