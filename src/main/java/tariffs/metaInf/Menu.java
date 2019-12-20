package tariffs.metaInf;

import java.util.Scanner;
import org.apache.log4j.Logger;

public class Menu {
    final static Logger logger = Logger.getLogger(Menu.class);
    private static final Scanner s = new Scanner(System.in);

    public static void printMainMenu() {
        logger.info("print menu list of available commands");

        System.out.println("\t\tMenu");
        System.out.println("<command> - explain command");

        MenuItems[] values = MenuItems.values();
        for (MenuItems item : values) {
            System.out.println(item.getDescription());
        }
    }

    private static boolean containsCommandByString(String command) {
        try {
            logger.debug("check if the command from user exit in list");
            MenuItems.valueOf(command);
        } catch (IllegalArgumentException e) {
            logger.debug(command + " not exit in  list");
            return false;
        }
        logger.debug("correct command");
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
