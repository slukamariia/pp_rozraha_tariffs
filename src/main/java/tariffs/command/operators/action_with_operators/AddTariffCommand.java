package tariffs.command.operators.action_with_operators;

import tariffs.command.Command;
import tariffs.model.Operator;
import tariffs.model.Tariff;

import java.util.Scanner;


public class AddTariffCommand implements Command {
    private static final Scanner in = new Scanner(System.in);
    private Tariff tariff;

    public AddTariffCommand(Operator operator) {
        this.tariff = tariff;
    }



    @Override
    public void execute() {
        System.out.println("\t\tAdd tariff");
        //Tariff tariff = readOperator();
        //storage.addTariff(tariff);

    }

}

    /*private Tariff readOperator() {
        System.out.println("\t\tAdd Tariff");
        System.out.print("name: ");
        String name = in.next();
        System.out.println("price: ");
        Integer price = in.nextInt();
        System.out.println("internet: ");
        Integer internet = in.nextInt();
        System.out.println("call: ");
        Integer call = in.nextInt();
        System.out.println("sms: ");
        Integer sms = in.nextInt();
        System.out.println("call to another: ");
        Integer callToAnother = in.nextInt();
        System.out.println("roaming: ");
        Integer roaming = in.nextInt();

        List<Client> client = new LinkedList<Client>();;
        System.out.println("client's number");
        String number = in.next();

        return new Tariff(name,price,internet,call,sms,callToAnother,roaming, client.add(number));
    }
/*    private Operator readOperator() {
        System.out.println("\t\tAdd Operator");
        System.out.print("name: ");
        String name = in.next();
        return new Operator(name);
    }

    @Override
    public void execute() {
        Operator operator = readOperator();
        storage.addOperator(operator);
    }*/