public class Programmer implements Jobs{
    private String namajob; 
    private int gaji; 
    public Programmer() { 
        this.namajob = "Programmer"; 
        this.gaji = 45;
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
