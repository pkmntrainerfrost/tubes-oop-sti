public class MagicClown implements Jobs {
    private String namajob;
    private int gaji;
    public MagicClown() {
        this.namajob = "MagicClown";
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