import java.util.Scanner;

public class DriverGeneral {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        World world = new World();
        System.out.println("Enter your new sim name: ");
        String nama = sc.nextLine();
        world.addSim(nama);

        System.out.println(world.getMediator("sim").getSimList());
    }
}
