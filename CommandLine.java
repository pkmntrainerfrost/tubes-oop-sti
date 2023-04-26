import java.util.Scanner;

public class CommandLine extends Exception{
    private static Scanner sc = new Scanner(System.in);
    private static String str;

    public static String heading(){
        System.out.println("Welcome To Simplicity!");
        System.out.println("Write out 'start game' or '1' to play!");
        str = sc.nextLine();
        return str;
    }

    public static String menuList(){
        System.out.println("Choose and write out the number or the word(s) of what you want to do!"); 
        System.out.println("Menu List: ");
        System.out.println("1. start game");
        System.out.println("2. help");
        System.out.println("3. exit");
        System.out.println("4. view sim info");
        System.out.println("5. view current location");
        System.out.println("6. view inventory");
        System.out.println("7. upgrade house");
        System.out.println("8. move room");
        System.out.println("9. edit room");
        System.out.println("10. add sim");
        System.out.println("11. change sim");
        System.out.println("12. list object");
        System.out.println("13. go to object");
        System.out.println("14. action");
        str = input.nextLine();
        return str;
    }

}

class WrongInputException extends Exception{
    public WrongInputException(String messageString){
        super(messageString);
    }
}