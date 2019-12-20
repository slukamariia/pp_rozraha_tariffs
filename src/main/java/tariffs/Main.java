package tariffs;

import tariffs.command.Command;
import tariffs.command.operators.*;
import tariffs.metaInf.EmailSender;
import tariffs.metaInf.MenuItems;
import tariffs.metaInf.Storage;

import java.util.HashMap;
import java.util.Map;

import static tariffs.metaInf.Menu.printMainMenu;
import static tariffs.metaInf.Menu.readCommand;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
    private static final  Logger logger = Logger.getLogger(Main.class);
    private static final String FILE_STORAGE_NAME = "data.xml";

    private static void init(Map<MenuItems, Command> commandMap, Storage storage) {
        logger.debug("initialize Menu-Map with commands");
        commandMap.put(MenuItems.PRINT, new PrintAllOperatorsInformationCommand(storage));
        commandMap.put(MenuItems.DEL, new DeleteOperatorCommand(storage));
        commandMap.put(MenuItems.ADD, new AddOperatorCommand(storage));
        commandMap.put(MenuItems.ACT, new ActionWithOperatorsCommand(storage));
        commandMap.put(MenuItems.EXIT, new ExitCommand());
        logger.debug("commands was successfully filled up");
    }

    public static void main(String[] args) throws InterruptedException {
        logger.info("The program was started.");

        Storage storage = new Storage(FILE_STORAGE_NAME);
        Map<MenuItems, Command> commandMap = new HashMap<>();
        init(commandMap, storage);

        while (true) {
            printMainMenu();
            MenuItems action = readCommand();

            Command command = commandMap.get(action);
            command.execute();

            if (command instanceof ExitCommand) {
                break;
            }

        }

        EmailSender emailSender = new EmailSender();
        emailSender.sendLogEmail();

        logger.info("The program was finished.");
    }

}





