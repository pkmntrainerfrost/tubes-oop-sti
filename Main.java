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
                Game.getInstance().initializeGame(name);
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
                case "start" :
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
                    cml.footer();
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
                    getGame().getCurrentSim().getCurrentRoom().moveRoom();
                    break;

                case "edit room":
                    System.out.println("Menu Edit Room:");
                    System.out.println("1. Buy item");
                    System.out.println("2. Move item");
                    System.out.println("3. Put item");
                    System.out.println("Write out the action to start doing it: ");
                    String action = in.nextLine();
                    action = cml.actionName(action);
                    if (action.equals("buyitem")){ 
                        getGame().getCurrentSim().getCurrentRoom().buyItem();
                    }else if(action.equals("moveitem")){
                        getGame().getCurrentSim().getCurrentRoom().moveItem();
                    }else if(action.equals("putitem")){
                        getGame().getCurrentSim().getCurrentRoom().putItem();
                    }else{
                        System.out.println("That is not an edit room action!");
                    }
                    break;
                case "add sim":
                    getGame().getCurrentSim().addSim();
                      break;

                case "change sim":
                    getGame().getCurrentSim().changeSim();
                    break;

                case "list object" :
                    getGame().getCurrentSim().getCurrentRoom().displayItemsInRoom();
                    break;

                case "go to object" :
                    getGame().getCurrentSim().getCurrentRoom().displayGoToObject();
                    break;

                case "action" :
                    cml.listActiveAction();
                    cml.makeTheActionMenu();
                    System.out.println("Choose your action: ");
                    String actionName = in.nextLine();
                    switch (cml.actionName(actionName)){ 
                        case "work":
                            Work work = new Work();
                            work.begin(getGame().getCurrentSim());
                            break;
                        case "exercise":
                            Exercise exercise = new Exercise();
                            exercise.begin(getGame().getCurrentSim);
                            break;
                        case "eat":
                            Eat eat = new Eat();
                            eat.begin(getGame().getCurrentSim);
                        case "sleep":
                            Sleep sleep = new Sleep();
                            sleep.begin(getGame().getCurrentSim);
                        case "cook":
                            Cook cook = new Cook();
                            cook.begin(getGame().getCurrentSim);
                        case "visit": //belum ditambahin untuk balik rumah asal
                            Visit visit = new Visit();
                            visit.begin(getGame().getCurrentSim);
                        case "pee":
                            Pee pee = new Pee();
                            pee.begin(getGame().getCurrentSim);
                        case "sing":
                            Sing sing = new Sing();
                            sing.begin(getGame().getCurrentSim);
                        case "meditation":
                            Meditation meditation = new Meditation();
                            meditation.begin(getGame().getCurrentSim);
                        case "readbook":
                            ReadBook readBook = new ReadBook();
                            readBook.begin(getGame().getCurrentSim);
                        case "watchmovie":
                            WatchMovie watchMovie = new WatchMovie();
                            watchMovie.begin(getGame().getCurrentSim);
                        case "drink":
                            Drink drink = new Drink();
                            drink.begin(getGame().getCurrentSim);
                        case "takebath":
                            TakeBath takeBath = new TakeBath();
                            takeBath.begin(getGame().getCurrentSim);
                        case "throwrubbish":
                            ThrowRubbish throwRubbish = new ThrowRubbish();
                            throwRubbish.begin(getGame().getCurrentSim());
                    }   
                    break;
                default :
            }
            CommandLine.clear();
            System.out.println("----------------------------------------");
        }
    }
}
