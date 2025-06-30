public class GameUtils {
    public int diceroll(){
        int diceFace;
        double luckFactor = Math.random();
        diceFace =(int)(luckFactor*6);
        return diceFace;
    }

}
