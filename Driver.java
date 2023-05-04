import java.util.*;

public class Driver {
    public static void main(String[] args) throws WrongInputException, NeighborFoundException, SimNotInHouseException, SimMiskinException, InterruptedException{
        CommandLine.setTerminalSize(44, 40);
        Scanner in = new Scanner(System.in);
        CommandLine cml = new CommandLine();
        cml.heading();
        cml.makeTheListMenu();
        boolean commandRight = false;
        String command = in.nextLine();
        while (!commandRight){
            if (cml.commandName(command).equals("start") || cml.commandName(command).equals("1")){
                cml.loadingScreen(10);
                System.out.println("New game has started");
                System.out.println("Create your first sim, sign their name!");
                String simName = in.nextLine();
                boolean nameRight = false;
                while (!nameRight){ //masih belom bisa looping input nama
                    if (cml.validateInputString(simName) instanceof String){
                        nameRight = true;
                    }else{
                        simName = in.nextLine();
                    }
                }
                // Sim sim = new Sim(simName); simnya blm jadi anjay 
                System.out.println("Hello! this is " + simName + " playing!");
                commandRight = true;
            }
            else if (cml.commandName(command).equals("load") || cml.commandName(command).equals("2")){
                System.out.println("input your file name: ");
                String fileName = in.nextLine();
                // loadFile(fileName);
                commandRight = true;
            }else{
                try {
                    throw new WrongInputException("Your game is not started yet! input your command again!");
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                command = in.nextLine();
            }

        }

        while (!cml.commandName(command).equals("exit")){
            System.out.println("What do you want to do?");
            System.out.println("Write out [2] or [help] if you need any help!");
            command = in.nextLine();
            switch(cml.commandName(command)) {
                case "1", "startgame" :
                    throw new WrongInputException("Your game is already started!");

                case "2", "help" :
                // tentukan dia di dalam room/house/hanya di dalam game
                    // if (sim.getCurrentState() == room){
                        cml.listMenuInRoom();
                        break;
                    //}else if (getCurrentState() == house){
                    //     cml.listMenuInHouse();
                    //     break;
                    // }else{
                    //     cml.listMenuInGame();
                    //     break;

                case "3", "exit" :
                    System.out.println("Do you want to save changes? [Y/N]");
                    String save = in.nextLine();
                    if (cml.validateInputString(save).equals("Y")){
                        System.out.println("Succesfully saved!");
                    }
                    break;

                case "4", "view sim info" :
                    
                    break;

                case "5", "view current location":
                    
                    break;

                case "6", "view inventory":
               
                    break;

                case "7", "upgrade house":

                    break;

                case "8", "move room":

                    break;

                case "9", "edit room":

                    break;
                case "10", "add sim":

                    break;

                case "11", "change sim":

                    break;

                case "12","list object" :

                    break;

                case "13","go to object" :

                    break;

                case "14","action" :
                    cml.listActiveAction();
                    System.out.println("Choose your action: ");
                    String actionName = in.nextLine();
                    break;
                default :
            }
        }
    }
}


// Point p = new Point(0, 0);
// Sim tata = new Sim("tata");
// House house = new House(p, tata, "rumah utama");
// house.upgradeHouse(house.getMainRoom(), "dapur", false, true);