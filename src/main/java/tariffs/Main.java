package main.java.tariffs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


    }
    public static final String TARIFF_KYIVSTAR = "KYIVSTAR";

    public static final Map<String, List<Tariff>> stringListMap = new HashMap<>();

    static {
        List<Tariff> tariffsKyivstar = new ArrayList<>();
        Tariff tariff_1 = new Tariff();
        tariffsKyivstar.add(tariff_1);

        Tariff tariff_2 = new Tariff();
        tariffsKyivstar.add(tariff_2);

        stringListMap.put(TARIFF_KYIVSTAR, tariffsKyivstar);
    }

}
