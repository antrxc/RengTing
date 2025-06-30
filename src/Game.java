public class Game {
    private String gameID;
    private int reng;
    private int deposit;
    private int current;

    public Game(String gameID, int deposit){
        this.gameID = gameID;
        this.reng = 0;
        this.deposit = deposit;
        this.current = 0;
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
