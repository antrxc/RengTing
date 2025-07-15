public class GameUtils {

    public int diceroll() {
        // Returns a dice roll between 1 and 6
        return (int) (Math.random() * 6) + 1;
    }

    public void moveUp(Game game) {
        game.updateReng(1);
    }

    public void moveDown(Game game) {
        game.updateReng(-1);
    }
}
