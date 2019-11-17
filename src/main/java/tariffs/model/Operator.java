package tariffs.model;

import nu.xom.Element;
import tariffs.model.XMLSerializable;

import java.util.List;

public class Operator implements XMLSerializable {

    private String name;
    private int amount;
    private List<Tariff> tariffs;

    public Operator(String name, int amount, List<Tariff> tariffs) {
        this.name = name;
        this.amount = amount;
        this.tariffs = tariffs;
    }

    public Element getXML() {
        Element operator =  new Element("operator");

        Element elName = new Element("name");
        Element elAmount = new Element("amount");

        Element elTariffs = new Element("tariffs");
        for(Tariff t: tariffs){
            elTariffs.appendChild(t.getXML());
        }

        operator.appendChild(elName);
        operator.appendChild(elAmount);
        operator.appendChild(elTariffs);

        return operator;
    }
}