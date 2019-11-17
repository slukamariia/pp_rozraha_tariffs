package tariffs.model;

import nu.xom.Element;
import nu.xom.Elements;
import tariffs.model.XMLSerializable;

import java.util.LinkedList;
import java.util.List;

public class Tariff implements XMLSerializable {

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

        this.name = elTariff.getFirstChildElement("name").getValue();
        this.price = Integer.parseInt(elTariff.getFirstChildElement("price").getValue());
        this.internet = Integer.parseInt(elTariff.getFirstChildElement("internet").getValue());
        this.call = Integer.parseInt(elTariff.getFirstChildElement("call").getValue());
        this.sms = Integer.parseInt(elTariff.getFirstChildElement("sms").getValue());
        this.callsToAnother = Integer.parseInt(elTariff.getFirstChildElement("callToAnother").getValue());
        this.roaming = Integer.parseInt(elTariff.getFirstChildElement("roaming").getValue());

        this.clients = new LinkedList<Client>();
        Element elClients = elTariff.getFirstChildElement("clients");
        Elements elsClients = elClients.getChildElements("number");

        for(int i = 0, n = elsClients.size(); i < n; i++) {
            this.clients.add(new Client(elsClients.get(i)));
        }

    }

    public Element getXML() {

        Element tariff = new Element("tariff");

        Element elName = new Element("name");
        Element elPrice = new Element("price");
        Element elInternet = new Element("internet");
        Element elCall = new Element("call");
        Element elSms = new Element("sms");
        Element elCallToAnother = new Element("callToAnother");
        Element elRoaming = new Element("roaming");

        Element elClients = new Element("clients");
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
        return "Tariff{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", internet=" + internet +
                ", call=" + call +
                ", sms=" + sms +
                ", callsToAnother=" + callsToAnother +
                ", roaming=" + roaming +
                ", clients=" + clients +
                '}';
    }
}


