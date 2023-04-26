public class Police implements Jobs {
    private String namajob;
    private int gaji;
    public Police() {
        this.namajob = "Police";
        this.gaji = 35;
    }
    public String getJobName(){
        return namajob = "Police";
    }
    public int getGaji(){
        return gaji;
    }
    public void addGaji(int gaji){
        this.gaji += gaji;
    }
}
