import java.util.Scanner;

public class GameLogic {
    enum State {
        PENALTY,
        NEUTRAL,
        UPWARD
    }

    private static final int[] MULTIPLIERS = { 0, 21, 25, 31, 36, 45, 60, 78, 100, 130, 200 };

    public void start(Game game) {
        GameUtils utils = new GameUtils();
        Player player = game.getPlayer();
        Scanner sc = new Scanner(System.in);

        int penaltyStreak = 0;
        boolean hasReachedReng1 = false;
        int turn = 1;

        DisplayUtils.printTitle("🎮 Starting Game for " + player.getName());
        DisplayUtils.printInfo("Initial Deposit: ₹" + game.getDeposit());

        while (game.getReng() < 10) {
            System.out.println();
            DisplayUtils.printTitle("🎮 GAMBA GAME — Turn #" + turn++);
            System.out.printf("Player: %s       |  Deposit: ₹%d\n", player.getName(), game.getDeposit());
            DisplayUtils.printSeparator();
            System.out.printf("🎲 Current Reng: %d\n", game.getReng());
            System.out.printf("🎯 Current State: %s\n", game.getState());
            System.out.printf("💰 Current Winnings: ₹%d\n", game.getCurrent());
            DisplayUtils.printSeparator();

            System.out.print("👉 Action: [R]oll or [L]eave?\n> ");
            String choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("l")) {
                DisplayUtils.printSuccess("You left the game.");
                System.out.printf("🏁 Final Reng: %d\n", game.getReng());
                System.out.printf("🏆 Final Winnings: ₹%d\n", game.getCurrent());
                return;
            }
            if (!choice.equals("r")) {
                DisplayUtils.printError("Invalid choice. Please type 'r' or 'l'.");
                continue;
            }

            int roll = rollDiceWithAnimation(utils);
            player.logRoll(roll);
            State currentState = game.getState();

            System.out.printf("🎲 You rolled: %d\n", roll);

            if (currentState == State.NEUTRAL && roll < 5) {
                if (game.getReng() == 0 && hasReachedReng1) {
                    DisplayUtils.printError("Game Over: PENALTY at Reng 0 after progress.");
                    return;
                }
                game.setState(State.PENALTY);
                penaltyStreak++;
                DisplayUtils.printWarning("State changed to PENALTY.");
            } else if (currentState == State.NEUTRAL && roll >= 5) {
                game.setState(State.UPWARD);
                penaltyStreak = 0;
                DisplayUtils.printSuccess("State changed to UPWARD.");
            } else if (currentState == State.PENALTY) {
                if (roll < 4) {
                    game.updateReng(-1);
                    DisplayUtils.printWarning("You dropped! Reng is now: " + game.getReng());
                } else {
                    game.setState(State.NEUTRAL);
                    DisplayUtils.printInfo("Recovered from PENALTY to NEUTRAL.");
                }

                if (penaltyStreak >= 2 && roll == 1) {
                    DisplayUtils.printError("Game Over: Rolled 1 after 2 penalty rounds!");
                    return;
                }

                penaltyStreak++;
            } else if (currentState == State.UPWARD) {
                if (roll > 3) {
                    game.updateReng(1);
                    DisplayUtils.printSuccess("Moved UPWARD! Reng is now: " + game.getReng());
                } else {
                    game.setState(State.NEUTRAL);
                    DisplayUtils.printInfo("Fell back to NEUTRAL state.");
                }
                penaltyStreak = 0;
            }

            if (game.getReng() >= 1) {
                hasReachedReng1 = true;
            }

            int reng = game.getReng();
            if (reng > 0 && reng < MULTIPLIERS.length) {
                int current = (game.getDeposit() * MULTIPLIERS[reng]) / 100;
                game.setCurrent(current);
            }

            System.out.printf("💰 New Winnings: ₹%d\n", game.getCurrent());
        }

        DisplayUtils.printSuccess("🎉 Congrats! You reached the final Reng: " + game.getReng());
        System.out.println("🏆 Final Winnings: ₹" + game.getCurrent());
    }

    private int rollDiceWithAnimation(GameUtils utils) {
        try {
            System.out.print(AnsiColors.PURPLE + "🎲 Rolling");
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                Thread.sleep(300);
            }
            System.out.println(AnsiColors.RESET);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return utils.diceroll();
    }
}
