package initialization;

import bot.Bot;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    static int shownBalance = 90;

    public static void clearConsole() {
        for (int i = 1; i <= 30; i++)
            System.out.println("\n");
    }

    public static void initMainMenu() {
        showMainMenu();

        int respond = scanner.nextInt();
        switch (respond) {
            case 1: // start
                Bot.initBot();
                Game.createOptions();
                break;
            case 2: // buy
                clearConsole();
                initUnitMenu();
                break;
            case 3: // return
                clearConsole();
                initReturnMenu();
                break;
            default:
                initMainMenu();
        }
    }

    private static void initUnitMenu() {
        showUnitMenu();
        Purchase.buyUnit(scanner.nextInt());
    }

    private static void initReturnMenu() {
        showUnitMenu();
        Purchase.returnUnit(scanner.nextInt());
    }

    private static void showMainMenu() {
        System.out.println("""
                Choose one of options:
                1. Start
                2. Buy new unit
                3. Return unit""");
    }

    private static void showUnitMenu() {
        System.out.println("Your balance is: " + shownBalance
                + "\nChoose unit:\n" +
                "1. Swordsman\n" +
                "2. Spearman\n" +
                "3. Axeman\n" +
                "4. Archer (long bow)\n" +
                "5. Archer (short bow)\n" +
                "6. Crossbowman\n" +
                "7. Knight\n" +
                "8. Cuirassier\n" +
                "9. Horsed archer");
    }
}
