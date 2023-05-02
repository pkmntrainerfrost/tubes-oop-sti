import java.util.*;

public class Game {
    
    private Map<String, Job> jobMap;
    private Map<String, Items> itemMap;

    private static Game instance = new Game();

    private Game(boolean load) {
        GameBuilder gameBuilder = load ? new LoadGameBuilder() : new NewGameBuilder();
        this.Game = gameBuilder.getGame();
    }

    public Map<String, Job> getJobMap() {
        return jobMap;
    }

    public static Game getInstance() {
        return instance;
    }


}
