import java.util.Scanner;

public class DriverGeneral {
    public static void main(String[] args) {
        CommandLine cli = new CommandLine();
        Scanner scanner = new Scanner(System.in);
        String nama = scanner.nextLine();
        cli.clear();
        System.out.println("coba lagi");
        cli.heading();
    }
}

/*
        Scanner sc = new Scanner(System.in);
        CommandLine cl = new CommandLine();
        System.out.println("Enter your new sim name: ");
        String nama = sc.nextLine();
        System.out.println(cl.validateInputString(nama));
 */