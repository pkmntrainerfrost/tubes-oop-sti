import java.util.*;
public class House extends GridObject{

    private Grid houseGrid;
    /* private Grid grid */
    /* private List<Room> rooms;  */

    private Sim owner;

    //konstruktor
    public House(Point p, Sim owner) {

        super(p,1,1);
        this.owner = owner;

        houseGrid = new Grid(5,5,5,5);
        try {
            houseGrid.addObject(new Room(new Point(0,0)));
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

    public void upgradeHouse(Room refRoom, boolean up, boolean right) throws NeighborFoundException, SimNotInHouseException{

        int x = right ? refRoom.getMaximumX() : refRoom.getMinimumY() - 1; 
        int y = up ? refRoom.getMaximumY() : refRoom.getMinimumY() - 1;

        Point p = new Point(x,y);
        Room newRoom = new Room(p);

        boolean add = false;

        if (!owner.getInHouse()) {
            throw new SimNotInHouseException("Sim is not in the house!");
        }

        do {
            try {
                houseGrid.addObject(newRoom); // sementara, belum ngurus dia makan waktu
                add = true;
            } catch (PositionOccupiedException e) {
                throw new NeighborFoundException("This direction is already occupied!");
            } catch (PositionOutOfBoundsException e) {
                houseGrid.addMaxX(1);
                houseGrid.addMaxY(1);
                houseGrid.addMinX(1);
                houseGrid.addMinY(1);
            }
        } while (!add);
        
        owner.setUang(-1500);

    }


    /*
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

    /*
    public List<Room> getRoomList() {
        return rooms;
    }
    */
    
    public Grid getHouseGrid(){
        return houseGrid;
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