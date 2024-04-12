package initialization;

import units.Unit;
import units.unitsTypes.*;

public class Purchase {
    private static Unit determineUnit(int index) {
        return switch (index) {
            case 1 -> new Swordsman();
            case 2 -> new Spearman();
            case 3 -> new Axeman();
            case 4 -> new BowmanLong();
            case 5 -> new BowmanShort();
            case 6 -> new Crossbowman();
            case 7 -> new Knight();
            case 8 -> new Cuirassier();
            default -> new HorseArcher();
        };
    }

    public static void buyUnit(int index) {
        if (Menu.shownBalance >= 10) {
            Menu.shownBalance = UnitCreation.createUnit(determineUnit(index));
        }

        Menu.initMainMenu();
    }


    public static void returnUnit(int index) {
        if (!UnitCreation.getUnits().isEmpty()) {
            Menu.shownBalance = UnitCreation.cancelCreation(determineUnit(index));
        }

        Menu.initMainMenu();
    }
}
