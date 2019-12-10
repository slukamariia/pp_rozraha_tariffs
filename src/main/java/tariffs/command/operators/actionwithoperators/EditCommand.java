package tariffs.command.operators.actionwithoperators;

import tariffs.command.Command;
import tariffs.model.Operator;

public class EditCommand implements Command {

    private Operator operator;

    public EditCommand(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void execute() {

    }

}
