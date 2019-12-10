package tariffs.command.operators.actionwithoperators;

import tariffs.command.Command;

public class ExitTariffMenu implements Command {
    @Override
    public void execute() {
        System.out.println("Exit form action with operator menu");
    }
}
