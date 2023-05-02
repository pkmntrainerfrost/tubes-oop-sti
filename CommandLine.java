import java.util.*;

/*
              G7!7P                                       &5JY#             PJJB       
     &&&&&    Y!!~J    ##       &#     &&&           &&&& B!!!P            &7!!Y    &#                           
  #5J77!!7J5# #5YP&   &7!G     #77&    J7777??JYP#  #777!G &#&               #&   B?7?              
 G!~!!777!~?# J!77B   G!!!B   #7!!G   &7!!!777!!!!5 B!!!7&&P55#  &G5JJJYG&  P55B  P~!?    #5G#  #PPG
 J~!!7G& &B   J!!!B   J!!!7# &?!!!J   B!!!?   G!!!!#G!!!P #!~~G G7!~!?7~~7B 7~~5B?7!!7??Y J~~5  P~~?
 B7!!!!?YG&   ?!!!#  #!!!!!?B?!!!!!#  P~!!J##BY!!~7&P~!7& #!!!G#!!!Y&  P?JP ?!~5#PJ!!?PPG&7!!#  Y~!Y
  &GYJ?777?P  J77?&  P777777?777777P  57777777777JB 5775  &?77BG777#        J775  G77Y   #77J   J77P
      &BYJJ?P YJJY   YJJJJJJJJJJJJJY  YJJJPPPPGB#   #GG&  &JJJBB?JJ#   #G#& YJJP  BJJ5   &JJJ& #JJJB
&PY5PGP5JJJ?P&YJJ5  #JJJJGJJJJJGJJJJ#&JJJJ&         &#&   &JJJB Y?JYBBGY??P YJ?P  B?JYGBGBP??JYJJJJB
BYJ?????JJ5B &JJ?P  P?JJY BJJJB YJJ?P#???Y         &Y?Y&  &JJ?B &PYJ???JYG  Y??P   5JJ???B BP5PGJJJ#
  &#BB##&&    ###& &YJJJG  GJP  GJJJYBPP5G          &#&    ###&   &#####    ###&    &####PPB   BJJJ&
                    &&&&    &    &&&&                                                    5??Y55JJJG 
                                                                                         &GYJJJY5B  
 */
public class CommandLine extends Exception{
    static ArrayList<String> listMenu = new ArrayList<String>();
    public void heading(){
        System.out.println("===========================================  Welcome To  ===========================================");
        System.out.println("              G7!7P                                       &5JY#             PJJB                    ");
        System.out.println("     &&&&&    Y!!~J    ##       &#     &&&           &&&& B!!!P            &7!!Y    &#              ");
        System.out.println("  #5J77!!7J5# #5YP&   &7!G     #77&    J7777??JYP#  #777!G &#&               #&   B?7?              ");
        System.out.println(" G!~!!777!~?# J!77B   G!!!B   #7!!G   &7!!!777!!!!5 B!!!7&&P55#  &G5JJJYG&  P55B  P~!?    #5G#  #PPG");
        System.out.println(" J~!!7G& &B   J!!!B   J!!!7# &?!!!J   B!!!?   G!!!!#G!!!P #!~~G G7!~!?7~~7B 7~~5B?7!!7??Y J~~5  P~~?");
        System.out.println(" B7!!!!?YG&   ?!!!#  #!!!!!?B?!!!!!#  P~!!J##BY!!~7&P~!7& #!!!G#!!!Y&  P?JP ?!~5#PJ!!?PPG&7!!#  Y~!Y");
        System.out.println("  &GYJ?777?P  J77?&  P777777?777777P  57777777777JB 5775  &?77BG777#        J775  G77Y   #77J   J77P");
        System.out.println("      &BYJJ?P YJJY   YJJJJJJJJJJJJJY  YJJJPPPPGB#   #GG&  &JJJBB?JJ#   #G#& YJJP  BJJ5   &JJJ& #JJJB");
        System.out.println("&PY5PGP5JJJ?P&YJJ5  #JJJJGJJJJJGJJJJ#&JJJJ&         &#&   &JJJB Y?JYBBGY??P YJ?P  B?JYGBGBP??JYJJJJB");
        System.out.println("BYJ?????JJ5B &JJ?P  P?JJY BJJJB YJJ?P#???Y         &Y?Y&  &JJ?B &PYJ???JYG  Y??P   5JJ???B BP5PGJJJ#");
        System.out.println("  &#BB##&&    ###& &YJJJG  GJP  GJJJYBPP5G          &#&    ###&   &#####    ###&    &####PPB   BJJJ&");
        System.out.println("                    &&&&    &    &&&&                                                    5??Y55JJJG ");
        System.out.println("                                                                                         &GYJJJY5B  ");
        System.out.println("====================================================================================================");
        System.out.println("write out [start game] to start a new game!");
        System.out.println("write out [load] [file name] to continue your previous game!");
    }

    public void makeTheListMenu(){
        listMenu.add("help");
        listMenu.add("exit");
        listMenu.add("view sim info");
        listMenu.add("view current location");
        listMenu.add("view inventory");
        listMenu.add("add sim");
        listMenu.add("change sim");
        listMenu.add("list object");
        listMenu.add("go to object");
        listMenu.add("action");
        listMenu.add("upgrade house");
        listMenu.add("move room");
        listMenu.add("add sim");
        listMenu.add("change sim");
    }

    public void listMenuInGame(){
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

    public void listMenuInHouse(){
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

    public void listMenuInRoom(){
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

    public void listActiveAction(){
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

    public void listEditRoom(){
        System.out.println("-buy item");
        System.out.println("-move item");
        System.out.println("-sell item");
    }

    public boolean validateCommand(String command){
        if (listMenu.contains(command)){
            return true;
        }else{
            try {
                throw new WrongInputException("The command is not valid!");
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public boolean validateInputInteger(String input){
        Integer inputInInteger = Integer.valueOf(input);
        if (inputInInteger instanceof Integer){
            return true;
        }else{
            try {
                throw new WrongInputException("The input is not valid!");
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public boolean validateInputString(String input){
        char[] inputInChar = new char[input.length()];
        for (int i = 0; i < input.length(); i++){
            inputInChar[i] = input.charAt(i);
        }
        for (int i = 0; i < input.length();i++){
            if (inputInChar[i] == '@'){
        }
    }

    public void executeCommand(String command){
        if ((command.equals(listMenu.get(0)))){
            do something
        }
    }
}

class WrongInputException extends Exception{
    public WrongInputException(String messageString){
        super(messageString);
    }
}