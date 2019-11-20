package tariffs;

import tariffs.command.MenuCommand;
import tariffs.command.PrintAllOperatorInformationCommand;
import tariffs.command.PrintAllOperatorInformationCommand;
import tariffs.metaInf.Storage;
import tariffs.model.Client;
import tariffs.model.Tariff;
import tariffs.model.Operator;

import java.util.*;



public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage("mobiles.xml");
        PrintAllOperatorInformationCommand getAllInformationCommand = new PrintAllOperatorInformationCommand(storage);
        getAllInformationCommand.execute();

        MenuCommand menu = new MenuCommand(storage);
        menu.execute();
    }

}
//        List<Tariff> tariffs = new LinkedList<Tariff>();
//
//        //-------------------------------------------------------
//        List<Client> clients1 = new LinkedList<Client>();
//
//        clients1.add( new Client("+380974554345") );
//        clients1.add( new Client("+380664657532") );
//
//
//        Tariff tariff1 = new Tariff("Plus",
//                60,
//                3000,
//                Integer.MAX_VALUE,
//                Integer.MAX_VALUE,
//                30,
//                0,
//                clients1);
//        tariffs.add(tariff1);
//
//        //-------------------------------------------------------
//        List<Client> clients2 = new LinkedList<Client>();
//
//        clients2.add( new Client("+32") );
//        clients2.add( new Client("+435") );
//
//        Tariff tariff2 = new Tariff("Plus",
//                80,
//                2000,
//                Integer.MAX_VALUE,
//                Integer.MAX_VALUE,
//                10,
//                100,
//                clients2);
//        tariffs.add(tariff2);
//
//
//        Operator kyiv = new Operator("Kyivstar", 1200, tariffs);
//
//        Storage database = new Storage("mobiles2.xml");
//        database.addOperator(kyiv);
//        database.save();
//        database.print();
//




