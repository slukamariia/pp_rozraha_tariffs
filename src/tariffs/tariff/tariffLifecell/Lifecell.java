package tariffs.tariff.tariffLifecell;

public abstract class Lifecell {
    protected String name;
    protected Integer price;
    protected Integer internet;
    protected Integer call;
    protected Integer sms;
    protected Integer callAnother;

    public Lifecell(){}

    public String getName() {   return name;    }

    public Integer getInternet() {   return internet;    }

    public Integer getCall() {  return call;    }

    public Integer getSms() {  return sms;    }

    public Integer getCallAnother() {  return callAnother;  }

    public Integer getPrice() {  return  price; }
}
