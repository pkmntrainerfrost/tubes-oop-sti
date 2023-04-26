import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class DriverAksi {
    public static void main(String args[]) throws Exception {

        // kasusnya ada 2 sim
        Sim sim1 = new Sim("sim1");
        Sim sim2 = new Sim("sim2");

        // scanner
        Scanner scan = new Scanner(System.in);

        // tampilan awal khusus sim1
        sim1.setInHouse(true);
        System.out.println();
        sim1.displaySimInfo();
        System.out.println();

        Items nasi = new Foods(5, "Nasi");
        Items ayam = new Foods(8, "Ayam");
        Items wortel = new Foods(2, "Wortel");

        sim1.getSimInventory().addItem(nasi, 20);
        sim1.getSimInventory().addItem(ayam, 15);
        sim1.getSimInventory().addItem(wortel, 1);

        System.out.println("INVENTORY SIM1");
        sim1.getSimInventory().displayInventory();
        System.out.println();
       
        // test aksi makanan beserta inventory
        Eat eatSim1 = new Eat(wortel, 30, sim1);

        // SIM1
        sim1.setInHouse(true);
        System.out.println();
        eatSim1.acted();
        sim1.displaySimInfo();
        System.out.println();

        // inventory ANDI
        System.out.println("INVENTORY SIM1");
        sim1.getSimInventory().displayInventory();
        System.out.println();
    }
}