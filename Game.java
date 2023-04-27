import java.util.*;

public class Game {
    
    private Map<String, Job> jobMap;
    private Map<String, Items> itemMap;

    private Clock clock;
    private World world;

    private static Game instance = new Game();

    private Game(boolean load) {
        GameBuilder gameBuilder = load ? new LoadGameBuilder() : new NewGameBuilder();
        this.Game = gameBuilder.getGame();
    }

    public Map<Job> getJobList() {
        return jobMap;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public List<Items> getItemList() {
        return itemList;
    }

    public void setItemList(List<Items> itemList) {
        this.itemList = itemList;
    }

}
