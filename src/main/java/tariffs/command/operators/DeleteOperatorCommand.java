package tariffs.command.operators;

import tariffs.metaInf.Menu;
import tariffs.command.Command;
import tariffs.metaInf.Storage;
import tariffs.model.Operator;

import java.util.List;

import static tariffs.metaInf.Operators.chooseOperatorByIndex;
import static tariffs.metaInf.Operators.printSuccess;
import org.apache.log4j.Logger;


public class DeleteOperatorCommand implements Command {
    private static final Logger logger = Logger.getLogger(DeleteOperatorCommand.class);
    private Storage storage;

    public DeleteOperatorCommand(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void execute() {
        logger.info("command: delete was selected");

        List<Operator> operators = storage.getAllOperators();
        Integer index;
        try {
            index = chooseOperatorByIndex(operators);
        } catch (NullPointerException ignored) {
            System.out.println("You have to create more operators");
            return;
        }

        storage.removeOperator(index);

        printSuccess();

    }

}
