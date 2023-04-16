import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Room extends GridObject {
    private int panjangRuang;
    private int lebarRuang;
    private List<Object> daftarObjek;

    public Room(Point point, int length, int width) {
    super(point, length, width);
    this.panjangRuang = length;
    this.lebarRuang = width;
    this.daftarObjek = new ArrayList<Object>();
    }

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

    public List<Object> getDaftarObject() {
        return daftarObjek;
    }

    public void setDaftarObject(List<Object> daftarObjek) {
        this.daftarObjek = daftarObjek;
    }
    
}