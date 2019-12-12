package tariffs.command.operators;

import tariffs.command.Command;
import tariffs.metaInf.Menu;
import tariffs.metaInf.Storage;
import tariffs.model.Operator;

import java.util.List;

public class PrintAllOperatorsInformationCommand implements Command {

    private Storage storage;

    public PrintAllOperatorsInformationCommand(Storage storage) {
        this.storage = storage;
    }

    public static void printOperatorsInformation(List<Operator> operators) {
        if (operators.isEmpty()) {
            System.out.println("List of operators is empty.");
            return;
        }
        operators.forEach(System.out::println);
    }

    public void execute() {
        printOperatorsInformation(storage.getAllOperators());
    }

}
