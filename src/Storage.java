import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private final HashMap<Player, String> playerHashMap = new HashMap<>();
    private final HashMap<Game, String> gameHashMap = new HashMap<>();
    private final HashMap<String, List<Game>> gameHistory = new HashMap<>();

    public void addPlayer(Player player) {
        playerHashMap.put(player, player.getPlayerID());
    }

    public void addGame(Game game) {
        gameHashMap.put(game, game.getGameID());

        String playerID = game.getPlayer().getPlayerID();
        List<Game> history = gameHistory.getOrDefault(playerID, new ArrayList<>());
        history.add(game);
        gameHistory.put(playerID, history);
    }

    public boolean playerExists(String playerID) {
        return playerHashMap.containsValue(playerID);
    }

    public HashMap<Player, String> getPlayerMap() {
        return new HashMap<>(playerHashMap);
    }

    public HashMap<Game, String> getGameMap() {
        return new HashMap<>(gameHashMap);
    }

    public List<Game> getGameHistory(String playerID) {
        return gameHistory.getOrDefault(playerID, new ArrayList<>());
    }

    public HashMap<String, List<Game>> getAllHistories() {
        return new HashMap<>(gameHistory);
    }
}
