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

    public void houseUpgrade(Room newRoom, String dir) throws Exception{
        // sementara 
        Room neighbor = rooms.get(0);
        boolean isCharaInHouse = true;
        if (isCharaInHouse){
            try {
                // Memastikan bahwa room yang akan ditambahkan terhubung dengan neighbornya
                if ((dir.equals("top") && neighbor.getMaximumY() == newRoom.getMinimumY()) || (dir.equals("under") && neighbor.getMinimumY() == newRoom.getMaximumY()) || (dir.equals("left") && neighbor.getMaximumX() == newRoom.getMinimumX()) || (dir.equals("right") && neighbor.getMinimumX() == newRoom.getMaximumX())) {
                    setHouseSize(6, dir);
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
            rooms.add(newRoom);
        }
        else{
            throw new Exception("You are not in your house!");
        }
    }

    public void setHouseSize(int num, String dir){
        if (dir.equals("right") | dir.equals("left")){
            grid.setGridX(6);
            setLength(num);
        }
        if (dir.equals("top") | dir.equals("under")){
            grid.setGridY(6);
            setHeight(num);
        }        
    }

    public Grid getGrid() { //pindah ke grid (?)
        return grid;
    }

    public List<Room> getRoomList() {
        return rooms;
    }

}

//sesuaikan aja yg bikin room nnt ini diapus, tp namanya samain kalo bisa
class Room extends GridObject {
    public Room(Point point, int length, int height) {
        super(point, length, height);
    }
}

