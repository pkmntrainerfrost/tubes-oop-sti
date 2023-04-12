import java.util.*;

public class World {

    // Implementasi World menggunakan Design Pattern Singleton

    private static World instance = new World();

    private World() {
        
    }

    public static World getInstance() {
        return instance;
    }

}