import java.util.List;
import java.util.Random;

public class Job {

    private String name;
    private int salary;

    public Job(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static Job generateRandomJob(List<Job> jobList) {
        return jobList.get(Random.nextInt(jobList.length()));
    }

}

/*
public class Job {
    private String name;
    private int salary;
    private static final String[] jobChoices = {"Badut Sulap", "Koki", "Polisi", "Programmer", "Dokter", "Guru", "Penulis", "Musisi"};
    private static final Random RANDOM = new Random();
    public Job(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static String getJobChoices() {
        int index = RANDOM.nextInt(jobChoices.length);
        return jobChoices[index];
    }
}
*/