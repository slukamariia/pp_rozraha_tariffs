package tariffs.command.operators.action_with_operators;

import tariffs.command.Command;
import tariffs.model.Operator;
import tariffs.model.Tariff;

import java.util.List;

public class FindTariffInRangeCommand implements Command {

    private Operator operator;

    public FindTariffInRangeCommand(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void execute() {
        System.out.println("\t\tFind");
    }

}