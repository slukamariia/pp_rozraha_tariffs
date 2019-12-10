package tariffs;

import tariffs.command.Command;
import tariffs.command.operators.ActionWithOperatorsCommand;
import tariffs.command.operators.DeleteOperatorCommand;
import tariffs.command.operators.ExitCommand;
import tariffs.command.operators.PrintAllOperatorsInformationCommand;
import tariffs.metaInf.Menu;
import tariffs.metaInf.Storage;

import java.util.HashMap;
import java.util.Map;


public class Main {

    private static final String FILE_STORAGE_NAME = "data.xml";

    private static void init(Map<String, Command> commandMap, Storage storage) {
        commandMap.put("/PRINT", new PrintAllOperatorsInformationCommand(storage));
        commandMap.put("/DELETE_OPERATOR", new DeleteOperatorCommand(storage));
        commandMap.put("/ACTION_WITH_OPERATORS", new ActionWithOperatorsCommand(storage));
        commandMap.put("/EXIT", new ExitCommand());
    }

    public static void main(String[] args) {

        Storage storage = new Storage(FILE_STORAGE_NAME);
        Map<String, Command> commnandMap = new HashMap<String, Command>();
        init(commnandMap, storage);

        while (true) {
            Menu.Operators.printMenu();
            String action = Menu.readCommand(commnandMap.keySet());

            Command command = commnandMap.get(action);
            command.execute();
        }

    }

}





