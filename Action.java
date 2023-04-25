public abstract class Action implements Runnable {

    private Sim sim;
    private int duration;

    // constructor
    public Action(Sim sim, int duration) {
        this.sim = sim;
        this.duration = duration;
    }

    public Action(Sim sim) {
        this.sim = sim;
    }

    public abstract void acted();

    // getter
    public Sim getSim() {
        return sim;
    }
    
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // setter
}

/*
class Work extends Action{

    public Work(int duration, Sim sim) {
        super(duration, sim);
    }

    @Override
    public void acted() {
        int time = getDuration()/30;
        for (int i = 0; i < time; i++){
            getSim().setKekenyangan(getSim().getKekenyangan()-10);
            getSim().setMood(getSim().getMood()-10);
        }
    }
}

class Exercise extends Action{

    public Exercise(int duration, Sim sim) {
        super(duration, sim);
    }

    @Override
    public void acted() {
        int time = getDuration()/20;
        for (int i = 0; i < time; i++){
            getSim().setKesehatan(getSim().getKesehatan()+5);
            getSim().setKekenyangan(getSim().getKekenyangan()-5);
            getSim().setMood(getSim().getMood()+10);
        }
    }
}

//masih cari tau bikin num nya tergantung makanannya, belom selesai
class Eat extends Action{

    public Eat(int duration, Sim sim) {
        super(duration, sim);
    }

    @Override
    public void acted() {
        int time = getDuration()/240; // 4 menit equals to 240 secs
        for (int i = 0; i < time; i++){
            getSim().setKesehatan(getSim().getKesehatan()+20);
            getSim().setMood(getSim().getMood()+30);
        }
    }
}
*/