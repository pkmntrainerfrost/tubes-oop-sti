import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Room extends GridObject {

    // Atribut yang digunakan untuk menyimpan objek-objek yang berada di dalam room
    private Grid objectGrid;

    // Atribut yang digunakan untuk menyimpan nama dari room
    private String name;

    // Atribut yang digunakan untuk menyimpan status selesainya room
    private boolean finished;

    // Konstruktor room dengan parameter titik awal, nama, dan status selesainya room
    public Room(Point point, String name, boolean finished) {
        // Memanggil konstruktor dari kelas induk (GridObject) dengan ukuran 6x6, karena room selalu memiliki ukuran 6x6
        super(point, 6, 6);

        // Membuat objek Grid dengan ukuran 6x6 untuk menyimpan objek-objek yang berada di dalam room
        objectGrid = new Grid(6, 6);

        // Mengatur nilai atribut name dengan parameter name yang diberikan
        this.name = name;

        // Mengatur nilai atribut finished dengan parameter finished yang diberikan
        finished = false;
    }

    // Metode untuk mengatur status selesainya room
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    // Metode untuk mendapatkan objek-objek yang berada di dalam room
    public List<GridObject> getObjects() {
        return objectGrid.getObjects();
    }

}