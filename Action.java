public abstract class Action {
    private String action;
    private int duration;
    private Sim sim;

    // constructor
    public Action(String action, int duration, Sim sim) {
        this.action = action;
        this.duration = duration;
        this.sim = sim;
    }

    public abstract void acted();

    // getter
    public String getAction() {
        return action;
    }

    public int getDuration(){
        return duration;
    }

    public Sim getSim(){
        return sim;
    }

    // setter
    public void setAction(String action) {
        this.action = action;
    }
}

class Work extends Action{

    public Work(String action, int duration, Sim sim) {
        super(action, duration, sim);
    }

    @Override
    public void acted() {
        int time = getDuration()/30;
        for (int i = 0; i < time; i++){
            getSim().setKekenyangan(-10);
        }
    }
}

class Exercise extends Action{

    public Exercise(String action, int duration, Sim sim) {
        super(action, duration, sim);
    }

    @Override
    public void acted() {
        int time = getDuration()/20;
        for (int i = 0; i < time; i++){
            getSim().setKesehatan(5);
            getSim().setKekenyangan(-5);
            getSim().setMood(10);
        }
    }
}

//masih cari tau bikin num nya tergantung makanannya, belom selesai
class Eat extends Action{

    public Eat(String action, int duration, Sim sim) {
        super(action, duration, sim);
    }

    @Override
    public void acted() {
        int time = getDuration()/240; // 4 menit equals to 240 secs
        for (int i = 0; i < time; i++){
            getSim().setKesehatan(20);
            getSim().setMood(30);
        }
    }
}