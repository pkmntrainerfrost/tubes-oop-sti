import java.util.Scanner;

public class DriverGeneral {
    public static void main(String[] args) {
        Game.getInstance().addSim("Arif");
        Game.getInstance().addSim("Duke");
        Game.getInstance().changeSim();
    }
}

/*
        Scanner sc = new Scanner(System.in);
        CommandLine cl = new CommandLine();
        System.out.println("Enter your new sim name: ");
        String nama = sc.nextLine();
        System.out.println(cl.validateInputString(nama));
 */