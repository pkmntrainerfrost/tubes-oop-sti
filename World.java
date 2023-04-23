import java.util.*;

public class World {

    // Implementasi World menggunakan Design Pattern Singleton

    private Grid houseGrid;

    private int seconds;
    private int days;

    private EventManager events;

    private static World instance = new World();

    private World() {
        events = new EventManager("timeincrement");
        houseGrid = new Grid(64,64);
        seconds = 0;
        days = 0;
    }

    public void incrementTime(int s) {
        seconds = seconds + s;
        days = seconds % 720;
        events.notify("timeincrement");
    }

    public int getSeconds() {
        return seconds;
    }

    public int getDays() {
        return days;
    }

    public static World getInstance() {
        return instance;
    }

    public EventManager getEvents() {
        return events;
    }

}
