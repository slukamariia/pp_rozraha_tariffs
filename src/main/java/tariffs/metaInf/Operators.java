package tariffs.metaInf;

import tariffs.model.Operator;

import java.util.List;
import java.util.Scanner;

public class Operators {

    private static final Scanner s = new Scanner(System.in);




    public static void printListOfOperators(List<Operator> operators) {
        System.out.println("\tList of operators");
        for (int i = 0, n = operators.size(); i < n; i++) {
            String name = operators.get(i).getName();
            System.out.println(i + ". " + name);
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
