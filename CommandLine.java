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
    static ArrayList<String> listAction = new ArrayList<String>();
    static String[] editRoomList = {"buyitem", "moveitem", "putitem"};

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
        System.out.println("write out [start] to start playing!");
    }

    public void footer(){
        System.out.println("==================thank you for playing, see you again!==========================");
        System.out.println("                                               /#(                               ");
        System.out.println("                                 **,**             #.                            ");
        System.out.println("                        **/     *,....,*      ##     #                           ");
        System.out.println("                      *,...,,*   *,.....,*       #    /#                         ");
        System.out.println("                       *,.....,/   *,.....,*      #    ,#          **/           ");
        System.out.println("                         *,.....,*   *,.....,*     #    .       /****/(          ");
        System.out.println("                     **/    *,.....,*   *,.....,/             *,,,,,**/          ");
        System.out.println("                   *,,,,,/   *,.....,*   *,.....,/           ,,,,,,,*/           ");
        System.out.println("                   ,,.....,*   *,.....,*   *,.....,/         ,,,,,,*/            ");
        System.out.println("                    *,......,*   *,.....,*   ,.....,*/      *,,,,,,*             ");
        System.out.println("                       *,......,/  /,......,,.......,,,,*,,,,,,,,,,*             ");
        System.out.println("                         *,......,*  *,.........................,,,*             ");
        System.out.println("                           *,......,*   ,........................,,,/            ");
        System.out.println("                    /,,,,,*   *,......,,...........,,............,,,*            ");
        System.out.println("                      *,....,*  *,.................,,............,,,*            ");
        System.out.println("            ,    #      *,,...,,/  ,............................,,,,*/           ");
        System.out.println("            /#    #.      *,,....,,,...........................,,,,**/           ");
        System.out.println("              #     ##       *,,..............................,,,,**/            ");
        System.out.println("                #       ##     /*,,,........................,,,,****,            ");
        System.out.println("                  (#              /*,,,,..................,,,,,***/              ");
        System.out.println("                       .             /*,,,............,,,,,,*****(               ");
        System.out.println("                                        /,,,,,,,,,,,,,,,,*****/                  ");
        System.out.println("                                           /*,,,,,,,,*****/(                     ");
        System.out.println("                                                 .,,                             "); 
        System.out.println("=================================================================================");
}
//doesnt work 
    public static void setTerminalSize(int columns, int lines) {
        System.out.print("\u001b[8;" + lines + ";" + columns + "t");
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    public void makeTheListMenu(){
        listMenu.add("start");
        listMenu.add("load");
        listMenu.add("help");
        listMenu.add("exit");
        listMenu.add("viewsiminfo");
        listMenu.add("viewcurrentlocation");
        listMenu.add("viewinventory");
        listMenu.add("addsim");
        listMenu.add("changesim");
        listMenu.add("listobject");
        listMenu.add("gotoobject");
        listMenu.add("action");
        listMenu.add("upgradehouse");
        listMenu.add("moveroom");
        listMenu.add("editroom");
        listMenu.add("addsim");
        listMenu.add("changesim");
    }

    public void makeTheActionMenu(){
        listAction.add("work");
        listAction.add("exercise");
        listAction.add("eat");
        listAction.add("sleep");
        listAction.add("cook");
        listAction.add("visit");
        listAction.add("pee");
        listAction.add("sing");
        listAction.add("meditation");
        listAction.add("readbook");
        listAction.add("watchmovie");
        listAction.add("drink");
        listAction.add("takebath");
        listAction.add("throwrubbish");
        listAction.add("buyitem");
        listAction.add("moveitem");
        listAction.add("putitem");
    }

    public void listMenuInGame(){
        System.out.println("Choose and write out the word(s) of what you want to do!"); 
        System.out.println("Menu List: ");
        System.out.println("1. start/load");
        System.out.println("2. help");
        System.out.println("3. exit");
        System.out.println("4. view sim info");
        System.out.println("5. view current location");
        System.out.println("6. view inventory");
        System.out.println("7. add sim");
        System.out.println("8. change sim");
        System.out.println("9. list object");
        System.out.println("10. go to object");
        System.out.println("11. action");
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
        System.out.println("1. Work");
        System.out.println("2. Exercise");
        System.out.println("3. Eat");
        System.out.println("4. Sleep");
        System.out.println("5. Cook");
        System.out.println("6. Visit");
        System.out.println("7. Pee");
        System.out.println("8. Sing");
        System.out.println("9. Meditation");
        System.out.println("10. Read Book");
        System.out.println("11.Watch Movie");
        System.out.println("12. Drink");
        System.out.println("13. Take Bath");
        System.out.println("14. Throw Rubbish");
    }

    public String commandName(String command){
        if (validateInputString(command)){
            command = command.replaceAll(" ", "");
            if (listMenu.contains(command.toLowerCase())){
                return command.toLowerCase();
            }else{
                System.out.println("Invalid command!");
            }
        }else{
            System.out.println("The input is not valid!");
        }
        return "";
    }

    public String actionName(String action){ 
        if (validateInputString(action)){
            action = action.replaceAll(" ", "");
            if (listAction.contains(action.toLowerCase())){
                return action.toLowerCase();
            }else{
                System.out.println("Wrong input of action");
            }
        }else{
            System.out.println("The input is not valid!");
        }
        return "";
    }

    public static boolean validateInputInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public boolean validateInputString(String input){
        input = input.replaceAll(" ", "");
        char[] inputInChar = new char[input.length()];
        boolean flag = true;
        for (int i = 0; i < input.length(); i++){
            inputInChar[i] = input.charAt(i);
        }
        for (int i = 0; i < inputInChar.length; i++){
            if (!Character.isLetter(inputInChar[i])){
                flag = false;
            }
        }
        return flag;
    }

    public boolean validateRoomName(String input, House house){
        boolean flag = true;
        for (int i = 0; i < house.getRoomList().size(); i++){
            if (((Room) house.getRoomList().get(i)).getRoomName().equals(input)){
                flag = false;
            }
        }
        return flag;
    }

    

    public void loadingScreen(int time){ // atur pake timenya buat titik titik
        System.out.printf("Loading");
        for (int i = 0; i < time; i++){
            System.out.printf(".");
        }
        System.out.printf("\n");
    }

}

/*
handling yang belom: 
repetitive start/load -> tinggal kasi exception WrongInput
validate file name for load and save 
setting terminal size 
 */


class WrongInputException extends Exception{
    public WrongInputException(String messageString){
        super(messageString);
    }
}