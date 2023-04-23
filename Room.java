import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Room extends GridObject {

    // gk perlu, dihardcode soalnya jadinya (ruangan pasti 6x6), di house cmn makan 1x1

    /*
    private int panjangRuang;
    private int lebarRuang;
    */

    // diganti grid
    // private List<Object> daftarObjek;

    private Grid objectGrid;

    public Room(Point point) {
        super(point, 1, 1);
        objectGrid = new Grid(6,6);
    }

    /*
    public Room(Point point) {
        super(point, length, width);
        this.panjangRuang = length;
        this.lebarRuang = width;
        this.daftarObjek = new ArrayList<Object>();
    }
    */

    // gk perlu, udah pasti 6x6

    /*
    public int getPanjangRuang() {
        return panjangRuang;
    }

    public void setPanjangRuang(int panjangRuang) {
        this.panjangRuang = panjangRuang;
    }

    public int getLebarRuang() {
        return lebarRuang;
    }

    public void setLebarRuang(int lebarRuang) {
        this.lebarRuang = lebarRuang;
    }
    */ 

    public List<GridObject> getObjects() {
        return objectGrid.getObjects();
    }

    /*
    public List<Object> getDaftarObject() {
        return daftarObjek;
    }

    public void setDaftarObject(List<Object> daftarObjek) {
        this.daftarObjek = daftarObjek;
    }
    */
    
}