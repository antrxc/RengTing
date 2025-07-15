import java.util.ArrayList;
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
                    storage.addPlayer(player);

                    // 🆕 Display Player ID
                    System.out.println("🆔 Your Player ID: " + player.getPlayerID());

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
                    storage.addGame(game);

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

                case "4":
                    System.out.print("🔍 Enter Player ID: ");
                    String pid = sc.nextLine().trim();

                    if (!storage.playerExists(pid)) {
                        System.out.println("❌ No such player found.");
                        break;
                    }

                    ArrayList<Game> history = new ArrayList<>(storage.getGameHistory(pid));
                    if (history.isEmpty()) {
                        System.out.println("📭 No games found for this player.");
                    } else {
                        System.out.println("\n📜 Game History:");
                        for (Game g : history) {
                            System.out.println("═════════════════════════════════");
                            System.out.println("🆔 Game ID: " + g.getGameID());
                            System.out.println("👤 Player: " + g.getPlayer().getName());
                            System.out.println("💵 Deposit: ₹" + g.getDeposit());
                            System.out.println("🎯 Final Reng: " + g.getReng());
                            System.out.println("🏆 Final Winnings: ₹" + g.getCurrent());
                            System.out.println("🎲 Rolls: " + g.getPlayer().getRollLog());
                        }
                    }
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please enter 1, 2, 3 or 4.");
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
        System.out.println("4️⃣  View Game History");
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
