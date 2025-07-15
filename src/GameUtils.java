public class GameUtils {
    public int diceroll() {
        return (int) (Math.random() * 6) + 1;
    }

    public void moveUp(Game game) {
        game.increaseReng(1);
    }

    public void moveDown(Game game) {
        game.decreaseReng(1);
    }
}
