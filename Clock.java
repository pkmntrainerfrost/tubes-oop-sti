import java.util.*;

public class Clock {

    private int seconds;
    private int days;
    private boolean running;
    private static Clock instance = new Clock();

    private Clock() {
        seconds = 0;
        days = 0;
        running = false;
    }

    public void runClock() {      
        new Thread(() -> {
            while (true) {
                if (running) {
                    try {
                        Thread.sleep(1000);
                        updateTime();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public synchronized void startClock() {
        running = true;
    }

    public synchronized void stopClock() {
        running = false;
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

    public void setTime(int seconds) {
        this.seconds = seconds;
        this.days = days % 720;
    }

    public void resetClock() {
        instance = new Clock();
    }

    public static Clock getInstance() {
        return instance;
    }
    
}
