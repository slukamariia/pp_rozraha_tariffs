package main.java.tariffs.model;

public class Tariff {
    protected String name;
    protected Integer price;
    protected Integer internet;
    protected Integer call;
    protected Integer sms;
    protected Integer callAnother;

    public Tariff(){}

    public Tariff(String name, Integer price, Integer internet, Integer call, Integer sms, Integer callAnother) {
        this.name = name;
        this.price = price;
        this.internet = internet;
        this.call = call;
        this.sms = sms;
        this.callAnother = callAnother;
    }

    public String getName() {   return name;    }

    public Integer getInternet() {   return internet;    }

    public Integer getCall() {  return call;    }

    public Integer getSms() {  return sms;    }

    public Integer getCallAnother() {  return callAnother;  }

    public Integer getPrice() {  return  price; }

}
