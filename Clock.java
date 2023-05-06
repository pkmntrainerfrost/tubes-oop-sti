import java.util.*;

public class Clock implements Runnable {

    private int seconds = 0;
    private int days;
    private boolean running = false;
    private Object lock = new Object();
    private static Clock instance = new Clock();

    private Clock() {
        seconds = 0;
        days = 0;
        running = false;
    }

    public void run() {      
        while(true) {
            synchronized(lock) {
                while (!running) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {

                    }
                }
            }
            try {
                Thread.sleep(1000);
                updateTime();
            } catch (InterruptedException e) {

            }
        }
    }

    public synchronized void startClock() {
        synchronized (lock) {
            running = true;
            lock.notifyAll();
        }
    }

    public synchronized void stopClock() {
        running = false;
    }

    public synchronized void updateTime() {
        this.seconds += 1;
        this.days = this.seconds / 720;
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
        this.days = seconds / 720;
    }

    public void resetClock() {
        instance = new Clock();
    }

    public static Clock getInstance() {
        return instance;
    }
    
}
