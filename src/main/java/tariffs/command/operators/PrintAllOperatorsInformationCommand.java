package tariffs.command.operators;

import tariffs.command.Command;
import tariffs.metaInf.Menu;
import tariffs.metaInf.Storage;
import tariffs.model.Operator;

import java.util.List;
import org.apache.log4j.Logger;

public class PrintAllOperatorsInformationCommand implements Command {
    private static final Logger logger = Logger.getLogger(PrintAllOperatorsInformationCommand.class);
    private Storage storage;

    public PrintAllOperatorsInformationCommand(Storage storage) {
        this.storage = storage;
    }

    public void printOperatorsInformation(List<Operator> operators) {
        if (operators.isEmpty()) {
            System.out.println("List of operators is empty.");
            return;
        }
        operators.forEach(System.out::println);
    }
    @Override
    public void execute() {
        logger.info("command: print list of operators");
        printOperatorsInformation(storage.getAllOperators());
    }

}
