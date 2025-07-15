import java.util.ArrayList;


public class GameLogic {

    enum State{
        PENALITY,
        NEUTRAL,
        UPWARD
    }
    public void startGame(Player player, Game game){
        GameUtils gm = new GameUtils();

        //game variables
        int diceFace;
        //int reng = game.getReng(); work with the reng value directly

        int deposit = game.getDeposit();
        int current = game.getCurrent();
        int state = 0; // game state -> penalty, upward, no change, etc...
        ArrayList<Integer> diceRolls = new ArrayList<>();
        while(true){
            diceFace = gm.diceroll();
            diceRolls.add(diceFace);
            
            //TODO implement game logic using the details from streams or from THE CHEMIST


        }
    }

    public void updateReng(Game game){

    }
}
