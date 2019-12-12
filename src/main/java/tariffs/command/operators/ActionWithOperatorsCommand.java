package tariffs.command.operators;

import tariffs.command.Command;
import tariffs.command.operators.action_with_operators.*;
import tariffs.metaInf.Storage;
import tariffs.model.Operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static tariffs.metaInf.Operators.chooseOperatorByIndex;

public class ActionWithOperatorsCommand  implements Command {

    private static final Scanner in = new Scanner(System.in);
    private Storage storage;
    private Map<ActionMenu, Command> commandMap = new HashMap<>();

    public ActionWithOperatorsCommand(Storage storage) {
        this.storage = storage;
    }

    private void init(Map<ActionMenu, Command> commandMap, Operator operator) {
        commandMap.put(ActionMenu.FIND, new FindTariffInRangeCommand(operator));
        commandMap.put(ActionMenu.ADD, new AddTariffCommand(operator));
        commandMap.put(ActionMenu.DEL, new DeleteTariffCommand(operator));
        commandMap.put(ActionMenu.BACK, new BackTariffMenu());
    }

    public static void printActionMenu() {
        System.out.println("\t\tMenu");

        ActionMenu[] values = ActionMenu.values();
        for (ActionMenu item : values) {
            System.out.println(item.getDescription());
        }
    }

    private static boolean containsCommandByString(String command) {
        try {
            ActionMenu.valueOf(command);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    public static ActionMenu readCommand() {
        String action;
        do {
            System.out.print("command: ");
            action = in.next().toUpperCase();
            in.nextLine();//clear buffer

        } while (!containsCommandByString(action));

        return ActionMenu.valueOf(action);
    }

    public void execute() {

        Integer chosenOperatorIndex;
        try {
            chosenOperatorIndex = chooseOperatorByIndex(storage.getAllOperators());
        } catch (NullPointerException ignored) {
            System.out.println("List of operator is empty.");
            return;
        }
        Operator operator = storage.getAllOperators().get(chosenOperatorIndex);

        init(commandMap, operator);

        while (true) {

            printActionMenu();
            ActionMenu action = readCommand();

            Command command = commandMap.get(action);
            if (command instanceof BackTariffMenu) {
                return;
            }
            command.execute();

        }

    }

}
