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
                System.out.println("Hello! this is " + Game.getInstance().getCurrentSim().getName() + " playing!");
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
                    Game.getInstance().getCurrentSim().displaySimInfo();
                    break;

                case "view current location":
                    Game.getInstance().getCurrentSim().displayCurrentLocation();
                    break;

                case "view inventory":
                    Game.getInstance().getCurrentSim().getInventory().displayInventory();
                    break;

                case "upgrade house":
                    Game.getInstance().getCurrentSim().getCurrentHouse().upgradeHouse();
                    break;

                case "move room":
                    System.out.println("Choose which room to go: ");
                    
                    Game.getInstance().getCurrentSim().getCurrentRoom().moveRoom(Game.getInstance().getCurrentSim(), );
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
                        Game.getInstance().getCurrentSim().getCurrentRoom().buyItem();
                    }else if(action.equals("moveitem")){
                        Game.getInstance().getCurrentSim().getCurrentRoom().moveItem();
                    }else if(action.equals("putitem")){
                        Game.getInstance().getCurrentSim().getCurrentRoom().putItem();
                    }else{
                        System.out.println("That is not an edit room action!");
                    }
                    break;
                case "add sim":
                    Game.getInstance().addSim();
                      break;

                case "change sim":
                    Game.getInstance().changeSim();
                    break;

                case "list object" :
                    Game.getInstance().getCurrentSim().getCurrentRoom().displayItemsInRoom();
                    break;

                case "go to object" :
                    Game.getInstance().getCurrentSim().getCurrentRoom().displayGoToObject();
                    break;

                case "action" :
                    cml.listActiveAction();
                    cml.makeTheActionMenu();
                    System.out.println("Choose your action: ");
                    String actionName = in.nextLine();
                    switch (cml.actionName(actionName)){ 
                        case "work":
                            Work work = new Work();
                            work.execute(Game.getInstance().getCurrentSim());
                            break;
                        case "exercise":
                            Exercise exercise = new Exercise();
                            exercise.execute(Game.getInstance().getCurrentSim());
                            break;
                        case "eat":
                            Eat eat = new Eat();
                            eat.execute(Game.getInstance().getCurrentSim());
                        case "sleep":
                            Sleep sleep = new Sleep();
                            sleep.execute(Game.getInstance().getCurrentSim());
                        case "cook":
                            Cook cook = new Cook();
                            cook.execute(Game.getInstance().getCurrentSim());
                        case "visit": //belum ditambahin untuk balik rumah asal
                            Visit visit = new Visit();
                            visit.execute(Game.getInstance().getCurrentSim());
                        case "pee":
                            Pee pee = new Pee();
                            pee.execute(Game.getInstance().getCurrentSim());
                        case "sing":
                            Sing sing = new Sing();
                            sing.execute(Game.getInstance().getCurrentSim());
                        case "meditation":
                            Meditation meditation = new Meditation();
                            meditation.execute(Game.getInstance().getCurrentSim());
                        case "readbook":
                            ReadBook readBook = new ReadBook();
                            readBook.execute(Game.getInstance().getCurrentSim());
                        case "watchmovie":
                            WatchMovie watchMovie = new WatchMovie();
                            watchMovie.execute(Game.getInstance().getCurrentSim());
                        case "drink":
                            Drink drink = new Drink();
                            drink.execute(Game.getInstance().getCurrentSim());
                        case "takebath":
                            TakeBath takeBath = new TakeBath();
                            takeBath.execute(Game.getInstance().getCurrentSim());
                        case "throwrubbish":
                            ThrowRubbish throwRubbish = new ThrowRubbish();
                            throwRubbish.execute(Game.getInstance().getCurrentSim());
                    }   
                    break;
                default :
            }
            CommandLine.clear();
            System.out.println("----------------------------------------");
        }
    }
}
