package main.java.tariffs.metaInf;

import main.java.tariffs.model.Tariff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


    }

    public static final String OPERATOR_KYIVSTAR = "KYIVSTAR";
    public static final String OPERATOR_LIFECELL = "LIFECELL";

    public static final Map<String, List<Tariff>> stringListMap = new HashMap<>();

    static {
        List<Tariff> tariffsKyivstar = new ArrayList<>();
        List<Tariff> tariffsLifecell = new ArrayList<>();
        Tariff tariff_1 = new Tariff("Super", 12,32,43,43,1);
        tariffsKyivstar.add(tariff_1);

        Tariff tariff_2 = new Tariff("Turbo", 54,24,12,4,100);
        boolean add = tariffsKyivstar.add(tariff_2);

        Tariff tariff_3 = new Tariff("Max",43, 42, 656, 53,23);
        tariffsLifecell.add(tariff_3);

        Tariff tariff_4 = new Tariff("Max",43, 42, 656, 53,23);
        tariffsLifecell.add(tariff_4);

        stringListMap.put(OPERATOR_KYIVSTAR, tariffsKyivstar);
        stringListMap.put(OPERATOR_LIFECELL, tariffsLifecell);
    }

}
