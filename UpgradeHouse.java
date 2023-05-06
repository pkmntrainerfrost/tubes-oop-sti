import java.util.*;

public class UpgradeHouse extends SimPassiveAction {

    Room room;
    
    public void begin(Sim sim) {
        boolean valid = false;
        if (!(sim.getCurrentHouse().getOwner().getName().equals(sim.getName()))) {
            System.out.println("Sorry, you must be in your house to upgrade.");
            setCancelled(true);
        } else {
            do {
                System.out.println("List of rooms:");
                int i = 1;
                for (GridObject room : sim.getCurrentHouse().getRoomList()) {
                    System.out.println(String.valueOf(i) + ". " + ((Room) room).getRoomName());
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
                    int x; int y; Point p; boolean validDir = true;
                    switch (dir.toLowerCase()) {
                        case "u":
                            x = room.getMinimumX();
                            y = room.getMaximumY();
                            break;
                        case "d":   
                            x = room.getMinimumX();
                            y = room.getMinimumY() - 1;
                            break;
                        case "l":
                            x = room.getMinimumX() - 1;
                            y = room.getMinimumY();
                            break;
                        case "r":
                            x = room.getMaximumX();
                            y = room.getMinimumY();
                            break;
                        default:
                            System.out.println("Invalid direction!");
                            validDir = false;
                            break;
                    }
                    if (validDir) {
                        boolean validName = true;
                        String newRoomName = scan.nextLine();
                        for (GridObject room : sim.getCurrentHouse().getRoomList()) {
                            if (((Room) room).getRoomName().equals(newRoomName)) {
                                System.out.println("Room name should not be duplicate!");
                                validName = false;
                            }
                        }
                        try {
                            sim.getCurrentHouse().upgradeHouse(room, newRoomName, p);
                        } catch (NeighborFoundException e) {
                            System.out.println("This direction is already occupied!");
                        } catch (SimNotInHouseException e) {
                            System.out.println("You are not in your house!");
                        } catch (SimMiskinException e) {
                            System.out.println("You don't have enough money!");
                        } catch (PositionOutOfBoundsException e) {
                            System.out.println("");
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

    }

    

}
