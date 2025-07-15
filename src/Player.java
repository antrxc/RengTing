import java.util.ArrayList;
import java.util.UUID;

public class Player extends Storage {
    private String name;
    private String playerID;
    private ArrayList<Integer> rollLog;

    public Player(String name) {
        this.name = name;
        this.rollLog = new ArrayList<>();
        this.playerID = generatePlayerID();
    }

    private String generatePlayerID() {
        return "PLAYER-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public String getName() {
        return name;
    }

    public String getPlayerID() {
        return playerID;
    }

    public ArrayList<Integer> getRollLog() {
        return rollLog;
    }

    public void logRoll(int roll) {
        rollLog.add(roll);
    }
}
