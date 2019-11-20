package tariffs.command;

import tariffs.metaInf.Storage;
import tariffs.model.Operator;

import java.sql.SQLOutput;
import java.util.List;

public class PrintAllOperatorInformationCommand implements  Command{

    private Storage storage;

    public PrintAllOperatorInformationCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute() {
        List<Operator> operators = storage.getAllOperators();
        for(Operator o : operators){
            System.out.println(o);
        }


    }

}
