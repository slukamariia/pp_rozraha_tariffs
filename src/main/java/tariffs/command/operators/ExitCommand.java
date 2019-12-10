package tariffs.command.operators;

import tariffs.command.Command;

public class ExitCommand implements Command {

    public void execute() {
        System.exit(0);
    }

}
