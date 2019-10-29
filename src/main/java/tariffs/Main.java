package main.java.tariffs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("kkkkk");

    }
    public static final String OPERATOR_KYIVSTAR = "KYIVSTAR";

    public static final Map<String, List<Tariff>> stringListMap = new HashMap<>();

    static {
        List<Tariff> tariffsKyivstar = new ArrayList<>();
        Tariff tariff_1 = new Tariff("Super", 12,32,43,43,1);
        tariffsKyivstar.add(tariff_1);

        Tariff tariff_2 = new Tariff("Turbo", 54,24,12,4,100);
        tariffsKyivstar.add(tariff_2);

        stringListMap.put(OPERATOR_KYIVSTAR, tariffsKyivstar);
    }

}
