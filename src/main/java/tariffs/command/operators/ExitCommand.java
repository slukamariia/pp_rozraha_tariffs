package tariffs.command.operators;

import tariffs.command.Command;
import org.apache.log4j.Logger;

public class ExitCommand implements Command {
    private static final Logger logger = Logger.getLogger(ExitCommand.class);

    @Override
    public void execute() {
        logger.info("command: exit was selected");
        System.out.println("The program was finished.");
        System.exit(0);
    }

}


