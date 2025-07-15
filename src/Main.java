import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        System.out.println("🎰 Welcome to the Gamba Game!");

        while (!exit) {
            printMenu();
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("👤 Enter Player Name: ");
                    String name = sc.nextLine();
                    Player player = new Player(name);
                    storage.getPlayerHashMap().put(player, player.getPlayerID());

                    int deposit = 0;
                    while (deposit <= 0) {
                        try {
                            System.out.print("💵 Enter Deposit Amount (₹): ");
                            deposit = Integer.parseInt(sc.nextLine().trim());
                            if (deposit <= 0) {
                                System.out.println("❌ Deposit must be positive.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("❌ Please enter a valid number.");
                        }
                    }

                    Game game = new Game(player, deposit);
                    storage.getGameHashMap().put(game, game.getGameID());

                    GameLogic logic = new GameLogic();
                    logic.start(game);

                    System.out.print("\n🔁 Play Again? [y/n]: ");
                    String again = sc.nextLine().trim().toLowerCase();
                    if (!again.equals("y")) {
                        exit = true;
                        System.out.println("👋 Thanks for playing!");
                    }
                    break;

                case "2":
                    printHelp();
                    break;

                case "3":
                    exit = true;
                    System.out.println("👋 Thanks for playing!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please enter 1, 2 or 3.");
            }
        }

        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n═════════════════════════");
        System.out.println("🎮 Gamba Game — Main Menu");
        System.out.println("1️⃣  Start New Game");
        System.out.println("2️⃣  Help / Rules");
        System.out.println("3️⃣  Exit");
        System.out.println("═════════════════════════");
        System.out.print("👉 Your Choice: ");
    }

    public static void printHelp() {
        System.out.println("\n📘 GAME RULES:");
        System.out.println("🎲 Roll the dice to climb up 'Rengs'");
        System.out.println("💸 Higher Reng = Higher winnings (multiplied)");
        System.out.println("⚠️  PENALTY state reduces Reng on low rolls");
        System.out.println("🏃 You can leave anytime and keep your winnings.");
        System.out.println("💥 Game ends if:");
        System.out.println("   - PENALTY at reng 0 (after reaching reng 1)");
        System.out.println("   - You roll 1 after 2 penalty rounds");
    }
}
