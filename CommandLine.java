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
        System.out.println("-help");
        System.out.println("-exit");
        System.out.println("-view sim info");
        System.out.println("-view current location");
        System.out.println("-view inventory");
        System.out.println("-upgrade house");
        System.out.println("-move room");
        System.out.println("-add sim");
        System.out.println("-change sim");
        System.out.println("-list object");
        System.out.println("-go to object");
        System.out.println("-action");
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

    public static void listActiveAction(){
        System.out.println("-Work");
        System.out.println("-Exercise");
        System.out.println("-Eat");
        System.out.println("-Sleep");
        System.out.println("-Cook");
        System.out.println("-Visit");
        System.out.println("-Pee");
        System.out.println("-Sing");
        System.out.println("-Meditation");
        System.out.println("-Read Book");
        System.out.println("-Watch Movie");
        System.out.println("-Drink");
        System.out.println("-Take Bath");
        System.out.println("-ThrowRubbish");
    }

    public static void listEditRoom(){
        System.out.println("-buy item");
        System.out.println("-move item");
        System.out.println("-sell item");
    }
}

class WrongInputException extends Exception{
    public WrongInputException(String messageString){
        super(messageString);
    }
}