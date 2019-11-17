package main.java.tariffs.model;

import java.util.List;

public class Tariff {
    private String name;
    private Integer price;
    private Integer internet;
    private Integer call;
    private Integer sms;
    private Integer callToAnother;
    private Integer roaming;
    private List<Client> clients;



    public Tariff(){}


}
