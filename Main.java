import java.util.*;

public class Main {
    public static void main(String[] args) throws WrongInputException, NeighborFoundException, SimNotInHouseException, SimMiskinException, InterruptedException, SimNotInGameException{
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
            System.out.println(command);
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

                case "viewsiminfo" :
                    Game.getInstance().getCurrentSim().displaySimInfo();
                    break;

                case "viewcurrentlocation":
                    Game.getInstance().getCurrentSim().displayCurrentLocation();
                    break;

                case "viewinventory":
                    Game.getInstance().getCurrentSim().getInventory().displayInventory();
                    break;

                // case "upgrade house":
                //     System.out.println("choose the reference room: ");
                //     String refRoomName = in.nextLine();
                //     Room refRoom = Game.getInstance().getCurrentSim().getCurrentRoom();
                //     Game.getInstance().getCurrentSim().getCurrentHouse().upgradeHouse();
                //     break;

                case "moveroom":
                    System.out.println("Choose which room to go: ");
                    Game.getInstance().getCurrentSim().moveRoom();
                    break;

                case "editroom":
                    System.out.println("Menu Edit Room:");
                    System.out.println("1. Buy item");
                    System.out.println("2. Move item");
                    System.out.println("3. Put item");
                    System.out.println("Write out the action to start doing it: ");
                    String action = in.nextLine();
                    action = cml.actionName(action);
                    if (action.equals("buyitem")){ 
                        Game.getInstance().getCurrentSim().buyItem();
                    }else if(action.equals("moveitem")){
                        Game.getInstance().getCurrentSim().moveItem();
                    }else if(action.equals("putitem")){
                        Game.getInstance().getCurrentSim().putItem();
                    }else{
                        System.out.println("That is not an edit room action!");
                    }
                    break;
                case "addsim":
                    String name = in.nextLine();
                    while (!cml.validateInputString(name)){
                        System.out.println("Invalid Name. Try again: ");
                        name = in.nextLine();
                    }
                    Game.getInstance().addSim(name);
                    break;

                case "changesim":
                    Game.getInstance().changeSim();
                    break;

                case "listobject" :
                    Game.getInstance().getCurrentSim().getCurrentRoom().displayItemsInRoom();
                    break;

                case "gotoobject" :
                    Game.getInstance().getCurrentSim().displayGoToObject();
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
            System.out.println("----------------------------------------");
        }
    }
}
