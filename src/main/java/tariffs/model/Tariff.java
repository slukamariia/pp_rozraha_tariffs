package tariffs.model;

import nu.xom.Element;
import tariffs.model.XMLSerializable;

import java.util.List;

public class Tariff implements XMLSerializable {
    private String name;
    private Integer price;
    private Integer internet;
    private Integer call;
    private Integer sms;
    private Integer callToAnother;
    private Integer roaming;
    private List<Client> clients;

    public Tariff(){}


    public Element getXML() {
        Element tariff = new Element("tariff");

        Element elName = new Element ("name");
        Element elPrice = new Element ("price");
        Element elInternet = new Element ("internet");
        Element elCall = new Element ("call");
        Element elSms = new Element ("sms");
        Element elCallToAnother = new Element ("callToAnother");
        Element elRoaming = new Element ("roaming");
        Element elClients = new Element ("clients");

        for(Client cl: clients){
            elClients.appendChild(getXML());
        }

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
}
