public class Doctor implements Jobs {
    private String namajob;
    private int gaji;
    public Doctor() {
        this.namajob = "Doctor";
        this.gaji = 50;
    }
    public String getJobName(){
        return namajob;
    }
    public int getGaji(){
        return gaji;
    }
    public void addGaji(int gaji){
        this.gaji += gaji;
    }
}