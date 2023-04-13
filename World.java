import java.util.*;

public class World {

    // Implementasi World menggunakan Design Pattern Singleton

    private Grid houseGrid;

    private static World instance = new World();

    private World() {
        houseGrid = new Grid(64,64);
    }

    public static World getInstance() {
        return instance;
    }

}