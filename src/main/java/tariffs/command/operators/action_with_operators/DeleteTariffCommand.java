package tariffs.command.operators.action_with_operators;

import tariffs.command.Command;
import tariffs.model.Operator;

public class DeleteTariffCommand implements Command {

    private Operator operator;

    public DeleteTariffCommand(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void execute() {
        System.out.println("\t\tDelete");
    }

}