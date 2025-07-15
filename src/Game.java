public class Game extends Storage{
    private String gameID;
    int reng;
    private int deposit;
    private int current;
    private GameLogic.State state;

    public Game(String gameID, int deposit){
        this.gameID = gameID;
        this.reng = 0;
        this.deposit = deposit;
        this.current = 0;
        this.state = GameLogic.State.NEUTRAL;
    }

    public String getGameID() {
        return gameID;
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


}
