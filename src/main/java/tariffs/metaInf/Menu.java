package tariffs.metaInf;


import java.util.Scanner;

public class Menu {
    private static final Scanner s = new Scanner(System.in);

    public static void printMainMenu() {
        System.out.println("\t\tMenu");

        MenuItems[] values = MenuItems.values();
        for (MenuItems item : values) {
            System.out.println(item.getDescription());
        }
    }

    private static boolean containsCommandByString(String command) {
        try {
            MenuItems.valueOf(command);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    public static MenuItems readCommand() {
        String action;
        do {
            System.out.print("command: ");
            action = s.next().toUpperCase();
            s.nextLine();//clear buffer

        } while (!containsCommandByString(action));

        return MenuItems.valueOf(action);
    }

}
