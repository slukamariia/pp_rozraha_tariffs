package main.java.tariffs;

public class Tariff {
    protected String name;
    protected Integer price;
    protected Integer internet;
    protected Integer call;
    protected Integer sms;
    protected Integer callAnother;

    public Tariff(){}

    public String getName() {   return name;    }

    public Integer getInternet() {   return internet;    }

    public Integer getCall() {  return call;    }

    public Integer getSms() {  return sms;    }

    public Integer getCallAnother() {  return callAnother;  }

    public Integer getPrice() {  return  price; }

}
