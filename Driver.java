import java.util.*;
public class Driver {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        CommandLine cml = new CommandLine();
        cml.heading();
        cml.makeTheListMenu();
        cml.listMenuInGame();
        String command = in.nextLine();
        char[] inCharArray = command.toCharArray();
        System.out.println(inCharArray);
    }
}
