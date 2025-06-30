public class GameUtils {
    public int diceroll(){
        int diceFace;
        double luckFactor = Math.random() + 0.1667;
        diceFace =(int)(luckFactor*6);
        return diceFace;
    }

}
