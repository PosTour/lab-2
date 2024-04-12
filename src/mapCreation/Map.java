package mapCreation;

import java.util.*;

public class Map {
    private static final int mapSize = 15;
    private static final ArrayList<ArrayList<Character>> map = new ArrayList<>(mapSize);

    public static void createMap() {
        for (int i = 0; i < mapSize; i++) {
            map.add(new ArrayList<>(mapSize));
            for (int j = 0; j < mapSize; j++) {
                map.get(i).add('*');
            }
        }

        map.get(2).set(1, '@');
        map.get(8).set(4, '@');
        map.get(5).set(6, '!');
        map.get(7).set(14, '!');
        map.get(12).set(9, '#');
    }

    public static Character returnMap(int x, int y) {
        return map.get(y).get(x);
    }

    public static void showMap() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                System.out.print(map.get(i).get(j));
            }
            System.out.println(" ");
        }
    }

    public static void addToMap(int x, int y, Character symbol) {
        map.get(y).set(x, symbol);
    }

    public static void removeFromMap(int x, int y) {
        map.get(y).set(x, '*');
    }
}
