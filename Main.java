import java.util.*;

public class Main {
    public static void main(String[] args) throws WrongInputException, NeighborFoundException, SimNotInHouseException, SimMiskinException, InterruptedException{
        CommandLine.setTerminalSize(44, 120);
        Scanner in = new Scanner(System.in);
        CommandLine cml = new CommandLine();
        cml.heading();
        cml.makeTheListMenu();
        boolean commandRight = false;
        String command = in.nextLine();
        while (!commandRight){
            if (cml.commandName(command).equals("start")){
                cml.loadingScreen(10);
                System.out.println("New game has started");
                System.out.println("--------------------");
                System.out.println("Insert your first sim name: ");
                String name = in.nextLine();
                Game game = Game(name);
                System.out.println("Hello! this is " + game.getCurrentSim().getName() + " playing!");
                commandRight = true;
            }else{
                System.out.println("Your game hasn't started yet! re-input your command!");
                command = in.nextLine();
            }

        }

        boolean isPlaying = true;
        while (isPlaying){
            System.out.println("What do you want to do?");
            System.out.println("Write out [help] if you need any help!");
            command = in.nextLine();
            switch(cml.commandName(command)) {
                case "start", "load" :
                    System.out.println("Your game is already started!");
                    break;

                case "help" :
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
                case "exit" :
                    System.out.println("Do you want to save changes? [Y/N]");
                    String save = in.nextLine();
                    while (!cml.validateInputString(save)){
                        save = in.nextLine();
                    }

                    while (!save.equals("Y") && !save.equals("N")){
                        System.out.println("Please input Y or N!");
                        save = in.nextLine();
                    }
                    if (save.equals(("Y"))){
                        System.out.println("Succesfully saved!");
                    }else if (save.equals("N")){
                        System.out.println("No changes saved!");
                    }
                    isPlaying = false;
                    break;

                case "view sim info" :
                    getGame().getCurrentSim().displaySimInfo();
                    break;

                case "view current location":
                    getGame().getCurrentSim().displayCurrentLocation();
                    break;

                case "view inventory":
                    getGame().getCurrentSim().displayInventory();
                    break;

                case "upgrade house":
                    getGame().getCurrentSim().getCurrentHouse().upgradeHouse();
                    break;

                case "move room":
                    getGame().get
                    break;

                case "edit room":

                    break;
                case "add sim":

                      break;

                case "change sim":

                    break;

                case "list object" :

                    break;

                case "go to object" :

                    break;

                case "action" :
                    cml.listActiveAction();
                    cml.makeTheActionMenu();
                    System.out.println("Choose your action: ");
                    String actionName = in.nextLine();
                    switch (cml.actionName(actionName)){ 
                        case "1", "work":
                            System.out.println("work is done");
                            break;
                        case "2", "exercise":
                            System.out.println("Exercise is done");
                            break;
                    }
                    break;
                default :
            }
            System.out.println("----------------------------------------");
        }
    }
}


// Point p = new Point(0, 0);
// Sim tata = new Sim("tata");
// House house = new House(p, tata, "rumah utama");
// house.upgradeHouse(house.getMainRoom(), "dapur", false, true);