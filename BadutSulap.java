public class BadutSulap implements Jobs {
    private String namajob;
    private int gaji;
    public Programmer() {
        this.namajob = "Badut Sulap";
        this.gaji = 15;
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
