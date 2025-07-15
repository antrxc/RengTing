public class Game extends Storage {
    private String gameID;
    private Player player;
    private int reng;
    private int deposit;
    private int current;
    private GameLogic.State state;

    public Game(Player player, int deposit) {
        this.player = player;
        this.gameID = generateGameID();
        this.reng = 0;
        this.deposit = deposit;
        this.current = 0;
        this.state = GameLogic.State.NEUTRAL;
    }

    private String generateGameID() {
        return "GAME-" + System.currentTimeMillis();
    }

    public String getGameID() {
        return gameID;
    }

    public Player getPlayer() {
        return player;
    }

    public int getReng() {
        return reng;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getCurrent() {
        return current;
    }

    public GameLogic.State getState() {
        return state;
    }

    public void setState(GameLogic.State state) {
        this.state = state;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void updateReng(int delta) {
        this.reng += delta;
        if (this.reng < 0) this.reng = 0;
    }
}
