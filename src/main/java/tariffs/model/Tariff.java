package tariffs.model;

import nu.xom.Element;
import nu.xom.Elements;

import java.util.LinkedList;
import java.util.List;

public class Tariff implements Comparable<Tariff>, XMLSerializable {

    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String INTERNET = "internet";
    public static final String CALL = "call";
    public static final String SMS = "sms";
    public static final String CALL_TO_ANOTHER = "callToAnother";
    public static final String ROAMING = "roaming";
    public static final String CLIENTS = "clients";
    public static final String NUMBER = "number";
    private String name;
    private Integer price;
    private Integer internet;
    private Integer call;
    private Integer sms;
    private Integer callsToAnother;
    private Integer roaming;
    private List<Client> clients;

    public Tariff(String name, Integer price, Integer internet, Integer call, Integer sms, Integer callsToAnother, Integer roaming, List<Client> clients) {
        this.name = name;
        this.price = price;
        this.internet = internet;
        this.call = call;
        this.sms = sms;
        this.callsToAnother = callsToAnother;
        this.roaming = roaming;
        this.clients = clients;
    }

    public Tariff(Element elTariff) {

        this.name = elTariff.getFirstChildElement(NAME).getValue();
        this.price = Integer.parseInt(elTariff.getFirstChildElement(PRICE).getValue());
        this.internet = Integer.parseInt(elTariff.getFirstChildElement(INTERNET).getValue());
        this.call = Integer.parseInt(elTariff.getFirstChildElement(CALL).getValue());
        this.sms = Integer.parseInt(elTariff.getFirstChildElement(SMS).getValue());
        this.callsToAnother = Integer.parseInt(elTariff.getFirstChildElement(CALL_TO_ANOTHER).getValue());
        this.roaming = Integer.parseInt(elTariff.getFirstChildElement(ROAMING).getValue());

        this.clients = new LinkedList<Client>();
        Element elClients = elTariff.getFirstChildElement(CLIENTS);
        Elements elsClients = elClients.getChildElements(NUMBER);

        for(int i = 0, n = elsClients.size(); i < n; i++) {
            this.clients.add(new Client(elsClients.get(i)));
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getInternet() {
        return internet;
    }

    public void setInternet(Integer internet) {
        this.internet = internet;
    }

    public Integer getCall() {
        return call;
    }

    public void setCall(Integer call) {
        this.call = call;
    }

    public Integer getSms() {
        return sms;
    }

    public void setSms(Integer sms) {
        this.sms = sms;
    }

    public Integer getCallsToAnother() {
        return callsToAnother;
    }

    public void setCallsToAnother(Integer callsToAnother) {
        this.callsToAnother = callsToAnother;
    }

    public Integer getRoaming() {
        return roaming;
    }

    public void setRoaming(Integer roaming) {
        this.roaming = roaming;
    }

    public List<Client> getClients() {
        return clients;
    }

    public Integer getSizeOfClients() {
        return clients.size();
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Element getXML() {

        Element tariff = new Element("tariff");

        Element elName = new Element(NAME);
        Element elPrice = new Element(PRICE);
        Element elInternet = new Element(INTERNET);
        Element elCall = new Element(CALL);
        Element elSms = new Element("sms");
        Element elCallToAnother = new Element(CALL_TO_ANOTHER);
        Element elRoaming = new Element(ROAMING);

        Element elClients = new Element(CLIENTS);
        for (Client cl: clients) {
            elClients.appendChild(cl.getXML());
        }

        elName.appendChild(name);
        elPrice.appendChild(String.valueOf(price));
        elInternet.appendChild(String.valueOf(internet));
        elCall.appendChild(String.valueOf(call));
        elSms.appendChild(String.valueOf(sms));
        elCallToAnother.appendChild(String.valueOf(callsToAnother));
        elRoaming.appendChild(String.valueOf(roaming));

        tariff.appendChild(elName);
        tariff.appendChild(elPrice);
        tariff.appendChild(elInternet);
        tariff.appendChild(elCall);
        tariff.appendChild(elSms);
        tariff.appendChild(elCallToAnother);
        tariff.appendChild(elRoaming);
        tariff.appendChild(elClients);

        return tariff;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");

        sb.append(String.format("| %-11s | %-5d | %-8d | %-4d | %-3d | %-16d | %-7d | %-7d |",
                name, price, internet,call,sms,callsToAnother,roaming,clients.size()));

        return sb.toString();
    }

    public int compareTo(Tariff o) {
        return Integer.compare(this.getPrice(), o.getPrice());
    }


}


