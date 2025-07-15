import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private final String name;
    private final String playerID;
    private final List<Integer> rollLog;

    public Player(String name) {
        this.name = name;
        this.playerID = "PLAYER-" + UUID.randomUUID().toString().substring(0, 8);
        this.rollLog = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPlayerID() {
        return playerID;
    }

    public List<Integer> getRollLog() {
        return new ArrayList<>(rollLog);
    }

    public void logRoll(int roll) {
        rollLog.add(roll);
    }
}
