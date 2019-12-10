package tariffs.command.operators;

import tariffs.command.operators.actionwithoperators.EditCommand;
import tariffs.command.operators.actionwithoperators.ExitTariffMenu;
import tariffs.metaInf.Menu;
import tariffs.command.Command;
import tariffs.metaInf.Storage;
import tariffs.model.Operator;

import java.util.HashMap;
import java.util.Map;

public class ActionWithOperatorsCommand  implements Command {

    private Storage storage;

    public ActionWithOperatorsCommand(Storage storage) {
        this.storage = storage;
    }

    private void init(Map<String, Command> commandMap, Operator operator) {
        commandMap.put("/edit", new EditCommand(operator));
        commandMap.put("/EXIT", new ExitTariffMenu());
    }

    public void execute() {

        Integer chosenOperatorIndex;
        try {
            chosenOperatorIndex = Menu.Operators.chooseOperatorByIndex(storage.getAllOperators());
        } catch (NullPointerException ignored) {
            System.out.println("List of operator is empty.");
            return;
        }
        Operator operator = storage.getAllOperators().get(chosenOperatorIndex);

        Map<String, Command> commandMap = new HashMap<>();
        init(commandMap, operator);

        while (true) {

            Menu.Action.printMainMenu();
            String action = Menu.readCommand(commandMap.keySet());

            Command command = commandMap.get(action);
            if (command instanceof ExitTariffMenu) {
                return;
            }
            command.execute();

        }

    }

}
