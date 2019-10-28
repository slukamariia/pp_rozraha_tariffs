package tariffs.tariff.tariffKievstar;

import java.util.Random;

public abstract class Kievstar {
    protected String name;
    protected Integer price;
    protected Integer internet;
    protected Integer call;
    protected Integer sms;
    protected Integer callAnother;
    protected Integer number;
    private static Random random = new Random();

    public Kievstar(){}

    public String getName() {   return name;    }

    public Integer getInternet() {   return internet;    }

    public Integer getCall() {  return call;    }

    public Integer getSms() {  return sms;    }

    public Integer getCallAnother() {  return callAnother;  }

    public Integer getPrice() {  return  price; }

    public Integer getNumber() {   return random.nextInt(number + 1);    }
}
