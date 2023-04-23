import java.lang.Math;

public class Visit extends Action {
    // belum based on jarak
    private int duration;

    public Visit(Point pointAwal, Point pointAkhir, Sim sim){
        super(sim);
        // duration dalam menit
        this.duration = (int) Math.sqrt((pointAkhir.getX() - pointAwal.getX()) + (pointAkhir.getY() - pointAwal.getY()));
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void acted() {
        int time = (getDuration() * 60)/30;
        for (int i = 0; i < time; i++){
            getSim().setMood(getSim().getMood()+10);
            getSim().setKekenyangan(getSim().getKekenyangan()-10);
        }
    }
}