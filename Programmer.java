public class Programmer implements Jobs{
    private String namajob;
    private int gaji;
    public Programmer() {
        this.namajob = "Programmer";
        this.gaji = 60;
    }
    public String getJobName(){
        return namajob;
    }
    public int getGaji(){
        return gaji;
    }
}
