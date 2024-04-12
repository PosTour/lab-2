package initialization;

import bot.Bot;
import mapCreation.Map;
import units.Unit;
import units.actions.Actions;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean playerSide = true;

    public static void createOptions() {
        if (!playerSide) {
            Bot.makeAMove();
        }

        if (checkIfEnded()) {
            showEndMenu();
            return;
        }

        Menu.clearConsole();
        Map.showMap();
        int x;
        int y;

        System.out.print("Choose your next move: \n1. Attack\n2. Move\n");
        switch (scanner.nextInt()) {
            case 1:
                System.out.print("Print in X coordinate of unit you want to attack with: ");
                x = scanner.nextInt();
                System.out.print("Print in Y coordinate of unit you want to attack with: ");
                y = scanner.nextInt();
                attack(x, y);
                break;
            case 2:
                System.out.print("Print in X coordinate of unit you want to move: ");
                x = scanner.nextInt();
                System.out.print("Print in Y coordinate of unit you want to move: ");
                y = scanner.nextInt();
                move(x, y);
        }
    }

    public static void attack(int x, int y) {
        ArrayList<Unit> units = UnitCreation.getUnits();

        for (Unit unit : units) {
            if (unit.getCoords()[0] == x && unit.getCoords()[1] == y) {

                System.out.print("Print in X coordinate you want unit to attack: ");
                int moveToX = scanner.nextInt();
                System.out.print("Print in Y coordinate you want unit to attack: ");
                int moveToY = scanner.nextInt();

                if (checkGivenPointForAttack(moveToX, moveToY)) {
                    Actions.attack(unit, x, y, moveToX, moveToY, Bot.getUnits());
                } else {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            }
        }

        createOptions();
    }

    private static void move(int x, int y) {
        ArrayList<Unit> units = UnitCreation.getUnits();

        for (Unit unit : units) {
            if (unit.getCoords()[0] == x && unit.getCoords()[1] == y) {

                System.out.print("Print in X coordinate you want unit to move to: ");
                int moveToX = scanner.nextInt();
                System.out.print("Print in Y coordinate you want unit to move to: ");
                int moveToY = scanner.nextInt();

                if (checkGivenPoint(moveToX, moveToY)) {
                    Actions.move(unit, x, y, moveToX, moveToY);
                } else {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            }
        }

        createOptions();
    }

    private static boolean checkGivenPoint(int x, int y) {
        char cellValue = Map.returnMap(x, y);

        if (x < 0 || x > 14 || y < 0 || y > 14) {
            System.out.println("\nYour point is out of bounds\n");
            return false;
        } else if (cellValue == '#' || cellValue == '@' || cellValue == '!') {
            System.out.println("\nYour point is an obstacle\n");
            return false;
        } else if (cellValue != '*') {
            System.out.println("\nYou point is occupied by another unit\n");
            return false;
        } else {
            return true;
        }
    }

    private static boolean checkGivenPointForAttack(int x, int y) {
        char cellValue = Map.returnMap(x, y);

        if (x < 0 || x > 14 || y < 0 || y > 14) {
            System.out.println("\nYour point is out of bounds\n");
            return false;
        } else if (cellValue == '#' || cellValue == '@' || cellValue == '!') {
            System.out.println("\nYour point is an obstacle\n");
            return false;
        } else if (cellValue == '*') {
            System.out.println("\nYou point is not occupied by another unit\n");
            return false;
        } else {
            return true;
        }
    }

    public static void changeSide(boolean side) {
        playerSide = side;
    }

    public static boolean getSide() {
        return playerSide;
    }

    private static boolean checkIfEnded() {
        return UnitCreation.getUnits().isEmpty() || Bot.getUnits().isEmpty();
    }

    private static void showEndMenu() {
        Menu.clearConsole();

        if (UnitCreation.getUnits().isEmpty()) {
            System.out.println("YOU LOST. TRY AGAIN");
        } else if (Bot.getUnits().isEmpty()) {
            System.out.println("WOW, YOU WON!");
        }
    }
}


