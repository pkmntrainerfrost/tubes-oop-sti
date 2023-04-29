public class Koki {
    private String namajob;
    private int gaji;
    public Programmer() {
        this.namajob = "Koki";
        this.gaji = 30;
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
