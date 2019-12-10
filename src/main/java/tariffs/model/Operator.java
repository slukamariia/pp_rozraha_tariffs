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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Tariff> getTariffs() {
        tariffs.sort(Tariff::compareTo);
        return tariffs;
    }

    public void setTariffs(List<Tariff> tariffs) {
        this.tariffs = tariffs;
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
        final StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%s (clients - %d)", name, amount)).append('\n');
        sb.append("----------------------------------------------------------------------------\n");
        sb.append("  # |     name    | price | internet | call | sms | calls to another | roaming | clients |").append('\n');
        sb.append("----------------------------------------------------------------------------\n");
        int num=1;
        for(Tariff t: tariffs){
            sb.append(String.format("%2d. %s ", num, t.toString())).append('\n');
            num++;
        }

        return sb.toString();
    }
}
