public class Game {
    private final String gameID;
    private final Player player;
    private int reng;
    private final int deposit;
    private int current;
    private GameLogic.State state;

    public Game(Player player, int deposit) {
        this.player = player;
        this.deposit = deposit;
        this.reng = 0;
        this.current = 0;
        this.state = GameLogic.State.NEUTRAL;
        this.gameID = "GAME-" + System.currentTimeMillis();
    }

    public String getGameID() {
        return gameID;
    }

    public Player getPlayer() {
        return player;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getReng() {
        return reng;
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

    public void increaseReng(int amount) {
        this.reng += amount;
    }

    public void decreaseReng(int amount) {
        this.reng -= amount;
        if (reng < 0) reng = 0;
    }

    public void updateReng(int delta) {
        this.reng += delta;
        if (this.reng < 0) this.reng = 0;
    }

}
