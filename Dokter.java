public class Dokter {
    private String namajob; 
    private int gaji; 
    public Programmer() { 
        this.namajob = "Dokter"; 
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
