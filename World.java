import java.util.*;

public class World {

    // Implementasi World menggunakan Design Pattern Singleton

    private Grid houseGrid;

    private int seconds;
    private int days;

    private static World instance = new World();

    private World() {
        houseGrid = new Grid(64,64);
        seconds = 0;
        days = 0;
    }

    public static World getInstance() {
        return instance;
    }
}
