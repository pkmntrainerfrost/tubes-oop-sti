import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class DriverAksi {
    public static void main(String args[]) throws Exception {

        // kasusnya ada 2 sim
        Sim andi = new Sim("andi");
        Sim budi = new Sim("budi");

        // scanner
        Scanner scan = new Scanner(System.in);

        // tampilan awal khusus andi
        andi.setInHouse(true);
        System.out.println();
        andi.displaySimInfo();
        System.out.println();

        andi.addItemToInventory("Nasi", "Foods", 20);
        andi.addItemToInventory("Ayam", "Foods", 15);
        andi.addItemToInventory("Wortel", "Foods", 1);

        System.out.println("INVENTORY ANDI");
        andi.getInventory().displayInventory();
        System.out.println();

        // tampilan awal khusus budi
        budi.setInHouse(true);
        System.out.println();
        budi.displaySimInfo();
        System.out.println();

        budi.addItemToInventory("Wortel", "Foods", 1);

        System.out.println("INVENTORY BUDI");
        budi.getInventory().displayInventory();
        System.out.println();

        // scanner dan test aksi makanan beserta inventory
        System.out.println("Masukkan makanan yang ingin dimakan: ");
        String scanMakanan = scan.next();
        Eat eatAndi = new Eat(scanMakanan, 30, andi);
        Eat eatBudi = new Eat(scanMakanan, 30, budi);

        Point pointAwal = new Point(0,0);
        Point pointAkhir = new Point(1,1);

        Visit visitAndi = new Visit(pointAwal, pointAkhir, andi);

        // ANDI
        andi.setInHouse(true);
        System.out.println();
        eatAndi.acted();
        visitAndi.acted();
        andi.displaySimInfo();
        System.out.println();

        // inventory ANDI
        System.out.println("INVENTORY ANDI");
        andi.getInventory().displayInventory();
        System.out.println();

        // BUDI
        budi.setInHouse(true);
        System.out.println();
        budi.displaySimInfo();
        System.out.println();

        // inventory BUDI
        System.out.println("INVENTORY BUDI");
        budi.getInventory().displayInventory();
        System.out.println();
        

    }
}