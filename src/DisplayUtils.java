public class DisplayUtils {
    public static void printTitle(String title) {
        System.out.println(AnsiColors.CYAN + "═════════════════════════════════════════════" + AnsiColors.RESET);
        System.out.println(AnsiColors.BOLD + title + AnsiColors.RESET);
        System.out.println(AnsiColors.CYAN + "═════════════════════════════════════════════" + AnsiColors.RESET);
    }

    public static void printSeparator() {
        System.out.println(AnsiColors.CYAN + "─────────────────────────────────────────────" + AnsiColors.RESET);
    }

    public static void printError(String message) {
        System.out.println(AnsiColors.RED + "❌ " + message + AnsiColors.RESET);
    }

    public static void printSuccess(String message) {
        System.out.println(AnsiColors.GREEN + "✅ " + message + AnsiColors.RESET);
    }

    public static void printWarning(String message) {
        System.out.println(AnsiColors.YELLOW + "⚠️  " + message + AnsiColors.RESET);
    }

    public static void printInfo(String message) {
        System.out.println(AnsiColors.BLUE + message + AnsiColors.RESET);
    }
}
