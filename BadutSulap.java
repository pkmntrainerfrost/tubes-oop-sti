public class BadutSulap implements Jobs {
    private String namajob;
    private int gaji;
    public BadutSulap() {
        this.namajob = "BadutSulap";
        this.gaji = 15;
    }
    public String getJobName(){
        return namajob;
    }
    public int getGaji(){
        return gaji;
    }
}