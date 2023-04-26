public class Koki implements Jobs {
    private String namajob;
    private int gaji;
    public Koki() {
        this.namajob = "Koki";
        this.gaji = 15;
    }
    public String getJobName(){
        return namajob;
    }
    public int getGaji(){
        return gaji;
    }
}
