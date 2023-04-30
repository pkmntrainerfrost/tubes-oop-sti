import java.util.Scanner;

public class CommandLine extends Exception{
    private static String str;

    public static void heading(){
        System.out.println("Welcome To Simp!icity!");
        System.out.println("Write out 'start game' to play!");
    }

    public static void listMenuInGame(){
        System.out.println("Choose and write out the word(s) of what you want to do!"); 
        System.out.println("Menu List: ");
        System.out.println("-help");
        System.out.println("-exit");
        System.out.println("-view sim info");
        System.out.println("-view current location");
        System.out.println("-view inventory");
        System.out.println("-add sim");
        System.out.println("-change sim");
        System.out.println("-list object");
        System.out.println("-go to object");
        System.out.println("-action");
    }

        public static void listMenuInHouse(){
            System.out.println("Choose and write out the word(s) of what you want to do!"); 
            System.out.println("Menu List: ");
            System.out.println("2. help");
            System.out.println("3. exit");
            System.out.println("4. view sim info");
            System.out.println("5. view current location");
            System.out.println("6. view inventory");
            System.out.println("7. upgrade house");
            System.out.println("8. move room");
            System.out.println("10. add sim");
            System.out.println("11. change sim");
            System.out.println("12. list object");
            System.out.println("13. go to object");
            System.out.println("14. action");
    }

    public static void listMenuInRoom(){
        System.out.println("Choose and write out the word(s) of what you want to do!"); 
        System.out.println("Menu List: ");
        System.out.println("-help");
        System.out.println("-exit");
        System.out.println("-view sim info");
        System.out.println("-view current location");
        System.out.println("-view inventory");
        System.out.println("-upgrade house");
        System.out.println("-move room");
        System.out.println("-edit room");
        System.out.println("-add sim");
        System.out.println("-change sim");
        System.out.println("-list object");
        System.out.println("-go to object");
        System.out.println("-action");
    }
}

class WrongInputException extends Exception{
    public WrongInputException(String messageString){
        super(messageString);
    }
}