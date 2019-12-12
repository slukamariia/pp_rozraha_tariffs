package tariffs.command.operators;

import tariffs.command.Command;
import tariffs.metaInf.Menu;
import tariffs.metaInf.Operators;
import tariffs.metaInf.Storage;
import tariffs.model.Operator;

import java.util.Scanner;

public class AddOperatorCommand implements Command {

    private static final Scanner in = new Scanner(System.in);
    private Storage storage;

    public AddOperatorCommand(Storage storage) {
        this.storage = storage;
    }

    private Operator readOperator() {
        System.out.println("\t\tAdd Operator");
        System.out.print("name: ");
        String name = in.next();
        return new Operator(name);
    }

    @Override
    public void execute() {
        Operator operator = readOperator();
        storage.addOperator(operator);
    }

}
