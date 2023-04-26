import java.lang.Math;

public class Visit extends SimActiveAction {
    private int duration;
    private boolean finished;

    public Visit(Point pointAwal, Point pointAkhir, Sim sim){
        super(sim);
        // duration dalam menit
        this.duration = (int) Math.sqrt((pointAkhir.getX() - pointAwal.getX()) + (pointAkhir.getY() - pointAwal.getY()));
        this.finished = false;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void act() {
        int time = (getDuration() * 60)/30;
        for (int i = 0; i < time; i++){
            getSim().setMood(getSim().getMood()+10);
            getSim().setKekenyangan(getSim().getKekenyangan()-10);
        }
    }

    @Override
    public void finish() {
        // TODO Auto-generated method stub
        finished = true;
    }
}
