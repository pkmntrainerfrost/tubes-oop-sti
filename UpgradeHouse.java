import java.util.*;

public class UpgradeHouse extends SimPassiveAction {

    Room room;
    
    public void begin(Sim sim) {
        setDuration(18 * 60);
        boolean valid = false;
        if (!(sim.getCurrentHouse().getOwner().getName().equals(sim.getName()))) {
            System.out.println("Sorry, you must be in your house to upgrade.");
            setCancelled(true);
        } else {
            do {
                System.out.println("List of rooms:");
                int i = 1;
                for (GridObject roomCheck : sim.getCurrentHouse().getRoomList()) {
                    System.out.println(String.valueOf(i) + ". " + ((Room) roomCheck).getRoomName());
                    i += 1;
                }
                System.out.println("Select a reference room [1-" + i + "] or type [cancel] to cancel:");
                CommandLine cLine = new CommandLine();
                Scanner scan = new Scanner(System.in);
                String roomChoice = scan.nextLine();
                if (CommandLine.validateInputInteger(roomChoice)) {
                    Room refRoom = (Room) sim.getCurrentHouse().getRoomList().get(Integer.valueOf(roomChoice) - 1);
                    System.out.println("Select direction [U/D/L/R]");
                    String dir = scan.nextLine();
                    int x; int y; Point p = new Point(0,0); boolean validDir = true;
                    switch (dir.toLowerCase()) {
                        case "u":
                            x = refRoom.getMinimumX();
                            y = refRoom.getMaximumY();
                            break;
                        case "d":   
                            x = refRoom.getMinimumX();
                            y = refRoom.getMinimumY() - 1;
                            break;
                        case "l":
                            x = refRoom.getMinimumX() - 1;
                            y = refRoom.getMinimumY();
                            break;
                        case "r":
                            x = refRoom.getMaximumX();
                            y = refRoom.getMinimumY();
                            break;
                        default:
                            System.out.println("Invalid direction!");
                            validDir = false;
                            break;
                    }
                    if (validDir) {
                        boolean validName = true;
                        String newRoomName = scan.nextLine();
                        for (GridObject roomCheck : sim.getCurrentHouse().getRoomList()) {
                            if (((Room) roomCheck).getRoomName().equals(newRoomName)) {
                                System.out.println("Room name must not be duplicate!");
                                validName = false;
                            }
                        }
                        try {
                            room = sim.getCurrentHouse().upgradeHouse(refRoom, newRoomName, p);
                            valid = true;
                        } catch (NeighborFoundException e) {
                            System.out.println("This direction is already occupied!");
                        } catch (SimNotInHouseException e) {
                            System.out.println("You are not in your house!");
                        } catch (SimMiskinException e) {
                            System.out.println("You don't have enough money!");
                        } 
                    }
                } else if (roomChoice.toLowerCase().equals("cancel")) {
                    setCancelled(true);
                    valid = true;
                } else {
                    System.out.println("Invalid input!");
                }
            } while (!valid);
                
        }
    }

    public void end(Sim sim) {
        room.setFinished(true);
    }

    

}
