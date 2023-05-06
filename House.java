import java.util.*;
public class House extends GridObject{

    private Grid roomGrid;
    /* private Grid grid */

    private Sim owner;

    private Room mainRoom;

    private String name;
    //konstruktor
    public House(Point p, Sim owner) {

        super(p,1,1);
        this.owner = owner;
        this.name = owner.getName() + "'s House";

        boolean success = false;

        do {
            try {
                World.getInstance().getHouseGrid().addObject(this);
                try {
                    roomGrid = new Grid(5,5);
                    // roomList = new ArrayList<Room>();
                    mainRoom = new Room(new Point(0,0),"Main Room",true);
                    roomGrid.addObject(mainRoom);
                    try {
                        // nambahin furniture stock
                        mainRoom.getObjectGrid().addObject(new FurnitureObject(new Point(0,0), (FurnitureType) Game.getInstance().getItemMap().get("Kasur Single")));
                        mainRoom.getObjectGrid().addObject(new FurnitureObject(new Point(0,5), (FurnitureType) Game.getInstance().getItemMap().get("Toilet")));
                        mainRoom.getObjectGrid().addObject(new FurnitureObject(new Point(4,0), (FurnitureType) Game.getInstance().getItemMap().get("Kompor Gas")));
                        mainRoom.getObjectGrid().addObject(new FurnitureObject(new Point(5,5), (FurnitureType) Game.getInstance().getItemMap().get("Jam")));
                        mainRoom.getObjectGrid().addObject(new FurnitureObject(new Point(2,2), (FurnitureType) Game.getInstance().getItemMap().get("Meja dan Kursi")));
                        success = true;
                    } catch (PositionOccupiedException | PositionOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                } catch (PositionOccupiedException | PositionOutOfBoundsException e) {
                    e.printStackTrace();
                }          
            } catch (PositionOccupiedException e) {
                if (p.getX() != 64) {
                    p.setX(p.getX() + 1);
                } else {
                    p.setY(p.getY() + 1);
                    p.setX(0);
                }
            } catch (PositionOutOfBoundsException e) {
                e.printStackTrace();
            }
        } while (!success);

    }

    /*
    public House (Point p, Grid grid){
        super(p, 6, 6);
        this.grid = grid;
        try {
            this.rooms = new ArrayList<Room>(); 
            // Menambahkan kamar pertama dengan ukuran 6x6 pada grid
            Room room = new Room(p, 6, 6); 
            grid.addObject(room);
            this.rooms.add(room);
        } catch (PositionOccupiedException | PositionOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    */

    public Room upgradeHouse(Room refRoom, String name, Point p) throws NeighborFoundException, SimNotInHouseException, SimMiskinException {

        Room newRoom = new Room(p,name,false);

        boolean add = false;

        if (owner.getCurrentHouse() != this) {
            throw new SimNotInHouseException("Sim is not in the house!");
        }

        if (owner.getUang() < 1500) {
            throw new SimMiskinException("Sim doesn't have enough money!");
        }

        do {
            try {
                roomGrid.addObject(newRoom); // sementara, belum ngurus dia makan waktu
                owner.addUang(-1500);
            } catch (PositionOccupiedException e) {
                throw new NeighborFoundException("This direction is already occupied!");
            } catch (PositionOutOfBoundsException e) {
                roomGrid.addMaxX(1);
                roomGrid.addMaxY(1);
                roomGrid.addMinX(1);
                roomGrid.addMinY(1);
            }
        } while (!add);

        return newRoom;

    }

    public List<GridObject> getRoomList() {
        return roomGrid.getObjects();
    }

    public Point getHousePoint(){
        return this.getPoint();
    }
    
    public String getHouseName(){
        return this.name;
    }
    
    public Grid getRoomGrid(){
        return roomGrid;
    }

    public Room getMainRoom(){
        return mainRoom;
    }

    public Sim getOwner() {
        return owner;
    }
}

class NoNeighborFoundException extends Exception{
    public NoNeighborFoundException(String messageString){
        super(messageString);
    }
}

class NeighborFoundException extends Exception{
    public NeighborFoundException(String messageString){
        super(messageString);
    }
}

class SimNotInHouseException extends Exception{
    public SimNotInHouseException(String messageString){
        super(messageString);
    }
}

class SimMiskinException extends Exception {
    public SimMiskinException(String messageString) {
        super(messageString);
    }
}