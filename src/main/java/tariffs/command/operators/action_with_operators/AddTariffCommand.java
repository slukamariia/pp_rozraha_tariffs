package tariffs.command.operators.action_with_operators;

import tariffs.command.Command;
import tariffs.model.Operator;

public class AddTariffCommand implements Command {

    private Operator operator;

    public AddTariffCommand(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void execute() {
        System.out.println("\t\tAdd tariff");
    }

}
