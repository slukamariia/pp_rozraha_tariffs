package tariffs.command;

import tariffs.metaInf.Storage;

import java.sql.SQLOutput;

public class MenuCommand implements Command {
    private Storage storage;

    public MenuCommand(Storage storage) {
        this.storage = storage;
    }
    public void menu(){
        System.out.println("Menu:");
        System.out.println("1. Print all operator information /printAllOperatorInformation");
        System.out.println();
    }

    public void execute() {
        menu();

    }
}
