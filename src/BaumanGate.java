import initialization.Menu;
import mapCreation.Map;

public class BaumanGate {
    public static void main(String[] args) {
        System.out.println("Welcome to Bauman's Gate");
        Map.createMap();
        Menu.initMainMenu();
    }
}
