import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    // Maps Player object to their PlayerID (String)
    private HashMap<Player, String> playerHashMap;

    // Maps Game object to their GameID (String)
    private HashMap<Game, String> gameHashMap;

    // Maps PlayerID (String) to a list of Games played (game history)
    private HashMap<String, ArrayList<Game>> gameHistory;

    public Storage() {
        playerHashMap = new HashMap<>();
        gameHashMap = new HashMap<>();
        gameHistory = new HashMap<>();
    }

    // Add a player to storage
    public void addPlayer(Player player) {
        playerHashMap.put(player, player.getPlayerID());
    }

    // Add a game to storage and register it under the player’s game history
    public void addGame(Game game) {
        gameHashMap.put(game, game.getGameID());

        String playerID = game.getPlayer().getPlayerID();
        ArrayList<Game> history = gameHistory.getOrDefault(playerID, new ArrayList<>());
        history.add(game);
        gameHistory.put(playerID, history);
    }

    // Get all players (Player -> PlayerID)
    public HashMap<Player, String> getPlayerHashMap() {
        return playerHashMap;
    }

    // Get all games (Game -> GameID)
    public HashMap<Game, String> getGameHashMap() {
        return gameHashMap;
    }

    // Get full game history map (PlayerID -> List of Games)
    public HashMap<String, ArrayList<Game>> getGameHistoryMap() {
        return gameHistory;
    }

    // Get game history for a specific playerID (returns empty list if none)
    public ArrayList<Game> getGameHistory(String playerID) {
        return gameHistory.getOrDefault(playerID, new ArrayList<>());
    }

    // Check if player exists by playerID
    public boolean playerExists(String playerID) {
        return playerHashMap.containsValue(playerID);
    }

    // Check if game exists by gameID
    public boolean gameExists(String gameID) {
        return gameHashMap.containsValue(gameID);
    }
}
