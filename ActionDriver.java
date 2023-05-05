import java.util.Scanner;

public class ActionDriver {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Sim kocak = new Sim("ALDIMALDINI");
        SimActiveAction visit = new Visit();
        visit.begin(kocak);
    }
}

/*
        Scanner sc = new Scanner(System.in);
        CommandLine cl = new CommandLine();
        System.out.println("Enter your new sim name: ");
        String nama = sc.nextLine();
        System.out.println(cl.validateInputString(nama));
 */