package tariffs.command.operators.actionwithoperators;

import tariffs.command.Command;
import tariffs.model.Operator;

public class DeleteTariffCommand implements Command {

    private Operator operator;

    public DeleteTariffCommand(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void execute() {

    }

}
