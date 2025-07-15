import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private HashMap<Player,String> playerHashMap; // Player and PlayerID
    private HashMap<Game,String> gameHashMap; // Game and GameID
    private HashMap<String, ArrayList<Game>> gameHistory; // PlayerID and Game history 

    public Storage(){
        playerHashMap = new HashMap<>();
        gameHashMap = new HashMap<>();
    }

    public HashMap<Player,String> getPlayerHashMap(){
        return playerHashMap;
    }

    public HashMap<Game, String> getGameHashMap() {
        return gameHashMap;
    }

    public HashMap<String, ArrayList<Game>> getGameHistory() {
        return gameHistory;
    }

    public ArrayList<Game> getGameHistory(String playerID){
        ArrayList<Game> playerHistory = new ArrayList<>();
        playerHistory = gameHistory.get(playerID);
        return playerHistory;
    }

}

