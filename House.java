import java.util.*;
public class House extends GridObject{
    private Grid grid;
    private List<Room> rooms; 

    //konstruktor
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

    public List<Room> getRoomList() {
        return rooms;
    }

    public Grid getGrid(){
        return grid;
    }

}

class NoNeighborFoundException extends Exception{
    public NoNeighborFoundException(String messageString){
        super(messageString);
    }
}

class SimNotInHouseException extends Exception{
    public SimNotInHouseException(String messageString){
        super(messageString);
    }
}