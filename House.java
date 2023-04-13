import java.util.*;
public class House {
    private Grid grid;
    private List<Room> rooms; 

    //konstruktor
    public House(int x, int y){
        this.grid = new Grid(x, y);
        this.rooms = new ArrayList<>(); 
        try {
            // Menambahkan kamar pertama dengan ukuran 6x6 pada grid
            Point p = new Point(x, y); //point awal rumah pakai inputan
            Room room = new Room(p, 6, 6); 
            grid.addObject(room);
            rooms.add(room);
        } catch (PositionOccupiedException | PositionOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    // sementara 
    boolean isCharaInHouse = true;

    public void houseUpgrade(Room newRoom, Room neighbor, String dir) throws Exception{
        if (isCharaInHouse){
            try {
                // Memastikan bahwa room yang akan ditambahkan terhubung dengan neighbornya
                if (neighbor == null || (dir.equals("top") && neighbor.getMaximumY() == newRoom.getMinimumY() - 1) || (dir.equals("under") && neighbor.getMinimumY() == newRoom.getMaximumY() + 1) || (dir.equals("left") && neighbor.getMaximumX() == newRoom.getMinimumX() - 1) || (dir.equals("right") && neighbor.getMinimumX() == newRoom.getMaximumX() + 1)) {
                    grid.addObject(newRoom);
                    rooms.add(newRoom);
                    //NOT YET: makan waktu untuk aksi
                }
                else {
                    throw new PositionOccupiedException("the room is not connected!");
                }
            } catch (PositionOccupiedException | PositionOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        else{
            throw new Exception("You are not in your house!");
        }
    }

    public Grid getGrid() { //pindah ke grid (?)
        return grid;
    }

    public List<Room> getRoomList() {
        return rooms;
    }
}

class Room extends GridObject {
    public Room(Point point, int length, int height) {
        super(point, length, height);
    }
}