package tariffs.model;

import nu.xom.Element;
import nu.xom.Elements;
import tariffs.model.XMLSerializable;

import java.util.LinkedList;
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

    public Operator(Element elOperator) {

        this.name = elOperator.getFirstChildElement("name").getValue();
        this.amount = Integer.parseInt(elOperator.getFirstChildElement("amount").getValue());

        tariffs = new LinkedList<Tariff>();
        Element elTariffs = elOperator.getFirstChildElement("tariffs");
        Elements elsTariffs = elTariffs.getChildElements("tariff");

        for(int i = 0, n = elsTariffs.size(); i < n; i++) {
            Element elTariff = elsTariffs.get(i);
            tariffs.add(new Tariff(elTariff));
        }

    }

    public Element getXML() {

        Element operator = new Element("operator");

        Element elName = new Element("name");
        Element elAmount = new Element("amount");

        elName.appendChild(name);
        elAmount.appendChild(String.valueOf(amount));

        Element elTariffs = new Element("tariffs");
        for (Tariff t: tariffs) {
            elTariffs.appendChild(t.getXML());
        }

        operator.appendChild(elName);
        operator.appendChild(elAmount);
        operator.appendChild(elTariffs);

        return operator;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", tariffs=" + tariffs +
                '}';
    }
}
