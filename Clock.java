import java.util.*;

public class Clock implements Runnable {

    private int seconds;
    private int days;

    private boolean running;

    private EventManager clockEventManager;

    private static Clock instance = new Clock();

    private Clock() {
        clockEventManager = new EventManager("clockUpdate");
        seconds = 0;
        days = 0;
    }

    public run() {
        while (true) {
            if (running) {
                delay(1000);
                updateTime();
            }
        }
    }

    public synchronized void startClock() {
        if (!running) {
            running = true;
            clockEventManager.notify("clockRunningUpdate");
        }
    }

    public synchronized void stopClock() {
        running = false;
        clockEventManager.notify("clockRunningUpdate");
    }

    public synchronized void updateTime() {
        this.seconds += 1;
        this.days = this.days % 720;
    }

    public synchronized int getSeconds() {
        return this.seconds;
    }

    public synchronized int getDays() {
        return this.days;
    }

    public synchronized boolean getRunning() {
        return this.running;
    }

    public synchronized void incrementActiveActionCount() {
        activeActionCount++;
    }

    public synchronized void decrementActiveActionCount() {
        activeActionCount--;
    }

    public void setTime(int seconds) {
        this.seconds = seconds;
        this.days = days % 720;
    }

    public void resetClock() {
        instance = new Clock();
    }

    public Clock getInstance() {
        return instance;
    }
    
}
