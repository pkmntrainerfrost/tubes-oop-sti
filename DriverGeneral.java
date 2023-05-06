import java.util.Scanner;

public class DriverGeneral {
    public static void main(String[] args) throws WrongInputException, NeighborFoundException, SimNotInHouseException, SimMiskinException, InterruptedException, SimNotInGameException{
        CommandLine.setTerminalSize(44, 120);
        Scanner in = new Scanner(System.in);
        CommandLine cml = new CommandLine();
        cml.heading();
        cml.makeTheListMenu();
        boolean commandRight = false;
        String command = in.nextLine();
        while (!commandRight){
            CommandLine.clear();
            if (cml.commandName(command).equals("start")){
                cml.loadingScreen(10);
                System.out.println("New game has started");
                System.out.println("--------------------");
                System.out.println("Insert your first sim name: ");
                String name = in.nextLine();
                Game.getInstance().initializeGame(name);
                System.out.println("Hello! this is " + Game.getInstance().getCurrentSim().getName() + " playing!");
                commandRight = true;
            } else{
                System.out.println("Your game hasn't started yet! re-input your command!");
                command = in.nextLine();
            }
            Eat eat = new Eat();
            eat.execute(Game.getInstance().getCurrentSim());

        }
        
        /*
        boolean isPlaying = true;
        while (isPlaying){
            System.out.println("What do you want to do?");
            System.out.println("Write out [help] if you need any help!");
            command = in.nextLine();
            System.out.println(cml.commandName(command));
            switch(cml.commandName(command)) {
                case "start" :
                    System.out.println("Your game is already started!");
                    break;

                case "help" :
                // tentukan dia di dalam room/house/hanya di dalam game
                    // if (sim.getCurrentState() == room){
                    cml.listMenuInGame();
                    break;
                    //}else if (getCurrentState() == house){
                    //     cml.listMenuInHouse();
                    //     break;
                    // }else{
                    //     cml.listMenuInGame();
                    //     break;
                case "exit" :
                    cml.footer();
                    isPlaying = false;
                    break;
                case "moveroom":
                System.out.println("Choose which room to go: ");
                Game.getInstance().getCurrentSim().moveRoom();
                    break;
                default:
            }
        }
        */
    }
}

/*
        Scanner sc = new Scanner(System.in);
        CommandLine cl = new CommandLine();
        System.out.println("Enter your new sim name: ");
        String nama = sc.nextLine();
        System.out.println(cl.validateInputString(nama));
 */