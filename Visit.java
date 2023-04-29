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

    public boolean getStatusFinish() {
        return finished;
    }

    @Override
    public void finish() {
        int time = (getDuration() * 60)/30;
        getSim().setMood(getSim().getMood() + (time * 10));
        getSim().setKekenyangan(getSim().getKekenyangan() - (time* 10));
        finished = true;
    }
}
