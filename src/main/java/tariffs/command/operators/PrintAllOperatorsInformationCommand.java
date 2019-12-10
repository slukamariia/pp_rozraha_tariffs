package tariffs.command.operators;

import tariffs.command.Command;
import tariffs.metaInf.Menu;
import tariffs.metaInf.Storage;

public class PrintAllOperatorsInformationCommand implements Command {

    private Storage storage;

    public PrintAllOperatorsInformationCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        Menu.Operators.printOperatorsInformation(storage.getAllOperators());
    }

}
