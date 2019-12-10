package tariffs.metaInf;


import tariffs.model.Client;
import tariffs.model.Operator;
import tariffs.model.Tariff;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    private static final Scanner s = new Scanner(System.in);


    public static class Operators {
        public static void printMenu() {
            System.out.println("\t\tMenu:");
            System.out.println("1. Print all operator information /PRINT_ALL_OPERATOR_INFORMATION");
            System.out.println("2. Delete operator /DELETE_OPERATOR");
            System.out.println("3. Take action with the selected operators /ACTION_WITH_OPERATORS");
            System.out.println("4. Exit /EXIT");
            // System.out.println("2. Add operator /ADD_OPERATOR");
        }


        public static void printListOfOperators(List<Operator> operators) {
            System.out.println("\tList of operators");
            for (int i = 0, n = operators.size(); i < n; i++) {
                String name = operators.get(i).getName();
                System.out.println(i + ". " + name);
            }
        }

        public static void printOperatorsInformation(List<Operator> operators) {
            if (operators.isEmpty()) {
                System.out.println("List of operators is empty.");
                return;
            }

            for (Operator o : operators) {
                System.out.println(o);
            }
        }

        public static Integer chooseOperatorByIndex(List<Operator> operators) {
            if (operators.isEmpty()) {
                throw new NullPointerException("operators list is empty");
            }

            Integer indexOperator;
            printListOfOperators(operators);
            do {
                System.out.print("choice: ");
                indexOperator = s.nextInt();
            } while (! (0 <= indexOperator && indexOperator < operators.size()) );

            return indexOperator;
        }

        public static void printSuccess() {
            System.out.println("Command was done successfully.");
        }

    }

    public static class Action {
        public static void printMainMenu() {
            /*
            Можливі опції:
                1. Output all information
                2. Output tariffs
                3. Output tariffs with external information
                4. Amount of clients.
                5. model.Tariff in range.
                6. Add tariff
                7. Edit tariff
                8. Delete tariff
             */
            System.out.println("/EXIT");
        }
    }

    public static String readCommand(Set<String> commands) {
        String action;
        do {
            System.out.print("command: ");
            action = s.next().toUpperCase();
            s.nextLine();//clear buffer
        } while(!commands.contains(action));

        return action;
    }

//    class Shit {
//        private enum Comm {
//            PRINT_ALL_OPERATOR_INFORMATION,
//            DELETE_OPERATOR,
//            ACTION_WITH_OPERANOR,
//            EXIT;
//        }
//
//
//        private enum TrueOrFalse {
//            YES, NO
//        }
//
//        public void addTarrifMenu(){
//            System.out.println("Fill out the form");
//
//            System.out.println("1. Write name of tarrif: ");
//            String name = s.next();
//
//            System.out.println("2. Write price of tariff: ");
//            Integer price = s.nextInt();
//
//            System.out.println("3. Input the number of megabytes: ");
//            Integer internet = s.nextInt();
//
//            System.out.println("4. Input the number of call: ");
//            Integer call = s.nextInt();
//
//            System.out.println("5. Input the number of sms: ");
//            Integer sms = s.nextInt();
//
//            System.out.println("5. Input the number of call to another user: ");
//            Integer callToAnother = s.nextInt();
//
//            System.out.println("5. Input the number of roaming: ");
//            Integer roaming = s.nextInt();
//
//            List<Client> clients = new LinkedList<Client>();
//
//            do {
//                System.out.println("Do u want to add client: ");
//                System.out.println("\t" +
//                        "Yes\tNo");
//                String choice = s.next().toUpperCase();
//
//                if(TrueOrFalse.NO.equals(choice)) {
//                    break;
//                }
//
//                Client client = addClient();
//                clients.add(client);
//            } while (true);
//
//            Tariff tariff =new Tariff(name, price, internet, call, sms, callToAnother, roaming, clients);
//        }
//
//        private Client addClient() {
//            System.out.println("Number: ");
//            String number = s.next();
//
//            return new Client(number);
//        }
//        private enum ListOfOperators {
//            KYIV, LIFE, VODAFON
//        }
//        public void ActionWithOperatorMenu(){
//            System.out.println("Possible action: ");
//            System.out.println("1. Output all information. /ALL_INFO_OPERATOR");
//            System.out.println("2. Output all tariffs. /ALL_TARIFFS");
//            System.out.println("3. Amount of clients for each operator. /AMOUNT_OF_CLIENTS");
//            System.out.println("4. Output tariffs with external information. /TARIFFS_WITH_EXTERNAL_INFO");
//            System.out.println("5. Tariffs in range. /TARIFFS_IN_RANGE");
//
//        }
//        private enum Parameter{
//            PRICE, MEGABYTES, CALL, SMS,
//            CALL_TO_ANOTHER, ROAMING, CLIENTS ;
//        }
//        public void TariffInRangeMenu(){
//            System.out.println("Select the types of parameter : ");
//            System.out.println("1. by price /PRICE");
//            System.out.println("2. by number of megabytes /MEGABYTES");
//            System.out.println("3. by number of call /CALL");
//            System.out.println("4. by number of sms /SMS");
//            System.out.println("5. by number of call to another /CALL_TO_ANOTHER");
//            System.out.println("6. by number of roaming /ROAMING");
//            System.out.println("7. by number of clients /CLIENTS");
//            System.out.println("You selected: ");
//
//        }
//        public void RangeMenu(){
//            System.out.println("from: ");
//            Integer limitFrom = s.nextInt();
//            System.out.println("to: ");
//            Integer limitTo = s.nextInt();
//        }
//
//        public void SelectOperatorMenu(){
//            System.out.println("Choice operator: ");
//            System.out.println("0. Select all operators.");
//            System.out.println("1. Kyivstar /KYIV");
//            System.out.println("2. Life /LIFE");
//            System.out.println("3. Vodafon /VODAFON");
//            System.out.println("You selected: ");
//        }
//
//        public void ActionWithTariffMenu(){
//            System.out.println("Select action with tariffs:");
//            System.out.println("1. Output all information.");
//            System.out.println("2. Output tariffs.");
//            System.out.println("3. Outputs tariffs with external information.");
//            System.out.println("4. Amount of clients for each tariff.");
//            System.out.println("5. Tariff in range.");
//            System.out.println("6. Add tariff.");
//            System.out.println("7. Edit tariff.");
//            System.out.println("8. Delete tariff.");
//            System.out.println("You selected: ");
//        }
//
//    }

}
