import java.util.*;

public class Game {
    
    private Map<String, Job> jobMap;
    private Map<String, Item> itemMap;

    private Clock clock;
    private World world;

    private static Game instance = new Game();

    private Game(boolean load) {
        GameBuilder gameBuilder = load ? new LoadGameBuilder() : new NewGameBuilder();
        this.Game = gameBuilder.getGame();
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

}
