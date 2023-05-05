import java.util.*;
public class House extends GridObject{

    private Grid houseGrid;
    /* private Grid grid */
    private ArrayList<Room> roomList;  

    private Sim owner;

    private Room mainRoom;

    private String name;

    private World world;

    //konstruktor
    public House(Point p, World world, Sim owner, String name) {

        super(p,1,1);
        this.owner = owner;
        this.name = name;
        this.world = world;
        world.addHouseToWorld(this);

        try {
            houseGrid = new Grid(5,5,5,5);
            // roomList = new ArrayList<Room>();
            mainRoom = new Room(new Point(0,0),"placeholder",true);
            houseGrid.addObject(mainRoom);
            System.out.println("house created");
            try {
                // nambahin furniture stock
                mainRoom.getObjectGrid().addObject(new FurnitureObject(new Point(0,0), (FurnitureType) Game.getInstance().getItemMap().get("Kasur Single")));
                mainRoom.getObjectGrid().addObject(new FurnitureObject(new Point(0,5), (FurnitureType) Game.getInstance().getItemMap().get("Toilet")));
                mainRoom.getObjectGrid().addObject(new FurnitureObject(new Point(4,0), (FurnitureType) Game.getInstance().getItemMap().get("Kompor Gas")));
                mainRoom.getObjectGrid().addObject(new FurnitureObject(new Point(3,0), (FurnitureType) Game.getInstance().getItemMap().get("Jam")));
                mainRoom.getObjectGrid().addObject(new FurnitureObject(new Point(2,2), (FurnitureType) Game.getInstance().getItemMap().get("Meja dan Kursi")));
            }
        } catch (PositionOccupiedException | PositionOutOfBoundsException e) {
            e.printStackTrace();
        }
        

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

    public void upgradeHouse(Room refRoom, String name, boolean up, boolean right) throws NeighborFoundException, SimNotInHouseException, SimMiskinException, PositionOutOfBoundsException {
        
        int x = right ? refRoom.getMaximumX() : refRoom.getMinimumY(); 
        int y = up ? refRoom.getMaximumY(): refRoom.getMinimumY();

        Point p = new Point(x,y);
        Room newRoom = new Room(p,name,true);

        boolean add = false;

        if (owner.getCurrentHouse() != this) {
            throw new SimNotInHouseException("Sim is not in the house!");
        }

        if (owner.getUang() < 1500) {
            throw new SimMiskinException("Sim doesn't have enough money!");
        }

        if(x == 0 && !up || y == 0 && !right){
            throw new PositionOutOfBoundsException("You cannot upgrade your house to that direction!");
        }else{
            do {
                try {
                    houseGrid.addObject(newRoom); // sementara, belum ngurus dia makan waktu
                    owner.setUang(-1500);
                    roomList.add(newRoom);
                    System.out.println("completed house upgrade");
                    // HouseUpgrade upgrade = new HouseUpgrade(owner, newRoom);
                    // World.getInstance().getEvents().subscribe("timeincrement", upgrade);
                } catch (PositionOccupiedException e) {
                    throw new NeighborFoundException("This direction is already occupied!");
                } catch (PositionOutOfBoundsException e) {
                    houseGrid.addMaxX(1);
                    houseGrid.addMaxY(1);
                    houseGrid.addMinX(1);
                    houseGrid.addMinY(1);
                }
            } while (!add);
        }
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }


    public String getHouseName(){
        return this.name;
    }
    
    public Grid getHouseGrid(){
        return houseGrid;
    }

    public Room getMainRoom(){
        return mainRoom;
    }

    /* 
    public void upgradeHouse(Room refRoom, String name, boolean up, boolean right) throws NeighborFoundException, SimNotInHouseException, SimMiskinException {
        
        int x = right ? refRoom.getMaximumX() : refRoom.getMinimumY() - 1; 
        int y = up ? refRoom.getMaximumY(): refRoom.getMinimumY() - 1;

        Point p = new Point(x,y);
        Room newRoom = new Room(p,name,true);

        boolean add = false;

        if (owner.getCurrentHouse() != this) {
            throw new SimNotInHouseException("Sim is not in the house!");
        }

        if (owner.getUang() < 1500) {
            throw new SimMiskinException("Sim doesn't have enough money!");
        }

        do {
            try {
                houseGrid.addObject(newRoom); // sementara, belum ngurus dia makan waktu
                owner.setUang(-1500);
                roomList.add(newRoom);
                System.out.println("completed house upgrade");
                // HouseUpgrade upgrade = new HouseUpgrade(owner, newRoom);
                // World.getInstance().getEvents().subscribe("timeincrement", upgrade);
            } catch (PositionOccupiedException e) {
                throw new NeighborFoundException("This direction is already occupied!");
            } catch (PositionOutOfBoundsException e) {
                houseGrid.addMaxX(1);
                houseGrid.addMaxY(1);
                houseGrid.addMinX(1);
                houseGrid.addMinY(1);
            }
        } while (!add);

    }



    public void upgradeHouse(Room newRoom, Sim sim, String dir) throws SimNotInHouseException, NoNeighborFoundException{
        // sementara 
        Room neighbor = null;
        // System.out.println(rooms.get(0).getMaximumX());
        // System.out.println(rooms.get(0).getMaximumY());        
        // System.out.println(rooms.get(0).getMinimumX());
        // System.out.println(rooms.get(0).getMinimumY());

        switch (dir) {
            case "top":
                neighbor = getBottomNeighbor(newRoom);
                break;
            case "bottom":
                neighbor = getTopNeighbor(newRoom);
                break;
            case "left":
                neighbor = getRightNeighbor(newRoom);
                break;
            case "right":
                neighbor = getLeftNeighbor(newRoom);
                break;
            default:
                throw new IllegalArgumentException("Invalid direction!");
        }
        
        setHouseSize(6, dir);

        if (sim.getInHouse()){
            try {
                // Memastikan bahwa room yang akan ditambahkan terhubung dengan neighbornya
                if ((dir.equals("top") && neighbor.getMaximumY() == newRoom.getMinimumY()) || (dir.equals("under") && neighbor.getMinimumY() == newRoom.getMaximumY()) || (dir.equals("left") && neighbor.getMinimumX() == newRoom.getMaximumX()) || (dir.equals("right") && neighbor.getMaximumX() == newRoom.getMinimumX())) {
                    grid.addObject(newRoom);
                    rooms.add(newRoom);
                    sim.setUang(-1500);
                    //NOT YET: makan waktu untuk aksi
                }
            } catch (PositionOccupiedException | PositionOutOfBoundsException e) {
                e.printStackTrace();
            }
            rooms.add(newRoom);
        }
        else{
            throw new SimNotInHouseException("Sim is not in the house!");
        }
    }
    
    public void setHouseSize(int num, String dir){
        if (dir.equals("right") | dir.equals("left")){
            grid.setGridX(6);
            setLength(num);
        }
        if (dir.equals("top") | dir.equals("under")){
            grid.setGridY(6);
            setWidth(num);
        }        
    }

    public Room getTopNeighbor(Room theRoom) throws NoNeighborFoundException {
        Room neighbor = null;
        for (Room anotherRoom : rooms){
            if(theRoom.getMaximumY() == anotherRoom.getMinimumY()){
                neighbor = anotherRoom;
            }else{
                throw new NoNeighborFoundException("There are no neighbors in your upper area");
            }
        }
        return neighbor;
    }

    public Room getBottomNeighbor(Room theRoom) throws NoNeighborFoundException {
        Room neighbor = null;
        for (Room anotherRoom : rooms){
            if(theRoom.getMinimumY() == anotherRoom.getMaximumY()){
                neighbor = anotherRoom;
            }else{
                throw new NoNeighborFoundException("There are no neighbors in your lower area");
            }
        }
        return neighbor;
    }

    public Room getLeftNeighbor(Room theRoom) throws NoNeighborFoundException{
        Room neighbor = null;
        for (Room anotherRoom : rooms){
            if(theRoom.getMinimumX() == anotherRoom.getMaximumX()){
                neighbor = anotherRoom;
            }else{
                throw new NoNeighborFoundException("There are no neighbors in your left area");
            }
        }
        return neighbor;
    }

    public Room getRightNeighbor(Room theRoom) throws NoNeighborFoundException{
        Room neighbor = null;
        for (Room anotherRoom : rooms){
            if(theRoom.getMaximumX() == anotherRoom.getMinimumX()){
                neighbor = anotherRoom;
            }else{
                throw new NoNeighborFoundException("There are no neighbors in your right area");
            }
        }
        return neighbor;
    }
    */


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