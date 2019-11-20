package tariffs.command;

import tariffs.metaInf.Storage;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuCommand implements Command {
    private Storage storage;
    public MenuCommand(Storage storage) {
        this.storage = storage;
    }
    private enum Comm{
        PRINT_ALL_OPERATOR_INFORMATION("Print all operator information"),
        EXIT("EXIT");

        private final String message;

        Comm(String message){
            this.message = message;
        }
        public String message(){
            return this.message;
        }
    }
    public void menu(){
        System.out.println("Menu:");
        System.out.println("1. Print all operator information /PRINT_ALL_OPERATOR_INFORMATION");
        System.out.println("2. Exit /EXIT");
    }
    while(true){
        Scanner s = new Scanner(System.in);
        try{
           while(true){

               System.out.println("Enter your choise");
               menu();
               int choice = s.nextInt();

               if(choice == Comm.PRINT_ALL_OPERATOR_INFORMATION.ordinal()){
                   Storage storage = new Storage("mobiles.xml");
                   PrintAllOperatorInformationCommand getAllInformationCommand = new PrintAllOperatorInformationCommand(storage);
                   getAllInformationCommand.execute();
               }
               else if(choice == Comm.EXIT.ordinal()){
                    ExitCommand exit = new ExitCommand();
                    exit.execute();
               }
               else{
                   System.out.println("Invalid command name entered!");
               }

           }
        }catch (IllegalArgumentException e){
            System.out.println("Error" + e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
            return;
        }
    }
    private static void displayList(){
        for(Comm c: Comm.values()){
            System.out.println(c.ordinal() + "  " + c.message());
        }
    }


    public void execute() {
        menu();

    }
}
