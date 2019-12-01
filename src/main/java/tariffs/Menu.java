package tariffs;


import tariffs.metaInf.Storage;
import tariffs.model.Client;
import tariffs.model.Tariff;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Storage storage;
    private Scanner s = new Scanner(System.in);

    public Menu(Storage storage) {
        this.storage = storage;
    }

    private enum Comm {
        PRINT_ALL_OPERATOR_INFORMATION("Print all operator information"),
        EXIT("EXIT");

        private final String message;

        Comm(String message) {
            this.message = message;
        }

        public String message() {
            return this.message;
        }
    }

    public void menu() {
        System.out.println("\t\tMenu:");
        System.out.println("1. Print all operator information /PRINT_ALL_OPERATOR_INFORMATION");
        System.out.println("2. Delete operator /DELETE_OPERATOR");
        System.out.println("3. Take action with the selected operators /ACTION_WITH_OPERATORS");
        System.out.println("4. Exit /EXIT");
       // System.out.println("2. Add operator /ADD_OPERATOR");
    }

    private enum TrueOrFalse {
        YES, NO
    }

    public void addTarrifMenu(){
        System.out.println("Fill out the form");

        System.out.println("1. Write name of tarrif: ");
        String name = s.next();

        System.out.println("2. Write price of tariff: ");
        Integer price = s.nextInt();

        System.out.println("3. Input the number of megabytes: ");
        Integer internet = s.nextInt();

        System.out.println("4. Input the number of call: ");
        Integer call = s.nextInt();

        System.out.println("5. Input the number of sms: ");
        Integer sms = s.nextInt();

        System.out.println("5. Input the number of call to another user: ");
        Integer callToAnother = s.nextInt();

        System.out.println("5. Input the number of roaming: ");
        Integer roaming = s.nextInt();

        List<Client> clients = new LinkedList<Client>();

        do {
            System.out.println("Do u want to add client: ");
            System.out.println("Yes\tNo");
            String choice = s.next().toUpperCase();

            if(TrueOrFalse.NO.equals(choice)) {
                break;
            }

            Client client = addClient();
            clients.add(client);
        } while (true);

        Tariff tariff =new Tariff(name, price, internet, call, sms, callToAnother, roaming, clients);
    }

    private Client addClient() {
        System.out.println("Number: ");
        String number = s.next();

        return new Client(number);
    }
    private enum Operator {
        KYIV, LIFE, VODAFON
    }
    public void ActionWithOperatorMenu(){
        System.out.println("Choice operator: ");
        System.out.println("0. Select all operators.");
        System.out.println("1. Kyivstar /KYIV");
        System.out.println("2. Life /LIFE");
        System.out.println("3. Vodafon /VODAFON");
        System.out.println("You selected: ");

        System.out.println("Possible action: ");
        System.out.println("1. Output all information. /ALL_INFO_OPERATOR");
        System.out.println("2. Output all tariffs. /ALL_TARIFFS");
        System.out.println("3. Output tariffs with external information. /TARIFFS_WITH_EXTERNAL_INFO");
        System.out.println("4. Amount of clients for each operator. /AMOUNT_OF_CLIENTS");
        System.out.println("5. Tariffs in range. /TARIFFS_IN_RANGE");

    }
    public void TariffInRangeMenu(){
        System.out.println("Select the types of parameter: ");
        System.out.println("1. by price");
        System.out.println("2. by number of megabytes");
        System.out.println("3. by number of call");
        System.out.println("4. by number of sms");
        System.out.println("5. by number of call to another");
        System.out.println("6. by number of roaming");
        System.out.println("7. by number of clients");

    }

    public void ActionWithTariff(){
        System.out.println("Choice operator: ");
        System.out.println("0. Select all operators.");
        System.out.println("1. Kyivstar /KYIV");
        System.out.println("2. Life /LIFE");
        System.out.println("3. Vodafon /VODAFON");

        System.out.println("You selected: ");
        System.out.println("Select action with tariffs:");
        System.out.println("1. Output all information.");
        System.out.println("2. Output tariffs.");
        System.out.println("3. Outputs tariffs with external information.");
        System.out.println("4. Amount of clients for each tariff.");
        System.out.println("5. Tariff in range.");
        System.out.println("6. Add tariff.");
        System.out.println("7. Edit tariff.");
        System.out.println("8. Delete tariff.");

    }

    private static void displayList(){
        for(Comm c: Comm.values()){
            System.out.println(c.ordinal() + "  " + c.message());
        }
    }



}
