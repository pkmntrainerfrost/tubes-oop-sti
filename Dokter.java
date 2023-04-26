public class Dokter implements Jobs {
    private String namajob;
    private int gaji;
    public Dokter() {
        this.namajob = "Dokter";
        this.gaji = 50;
    }
    public String getJobName(){
        return namajob;
    }
    public int getGaji(){
        return gaji;
    }
}