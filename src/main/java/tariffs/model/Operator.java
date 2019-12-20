package tariffs.model;

import nu.xom.Element;
import nu.xom.Elements;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Operator implements XMLSerializable {

    public static final String NAME = "name";
    public static final String TARIFFS = "tariffs";
    private String name;
    private List<Tariff> tariffs;

    public Operator(String name) {
        this.name = name;
        this.tariffs = new LinkedList<>();
    }
    public Operator(){

    }

    public Operator(Element elOperator) {

        this.name = elOperator.getFirstChildElement(NAME).getValue();

        tariffs = new LinkedList<Tariff>();
        Element elTariffs = elOperator.getFirstChildElement(TARIFFS);
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
        int sum = 0;
        for (Tariff t : tariffs) {
            sum += t.getSizeOfClients();
        }
        return sum;
    }

    public List<Tariff> getTariffs() {
        tariffs.sort(Tariff::compareTo);
        return tariffs;
    }

    public void setTariffs(List<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    public List<Tariff> getInRange(int start, int end) {
        List<Tariff> foundTariffs = new ArrayList<>();
        for (Tariff t : tariffs) {
            if (start <= t.getPrice() && t.getPrice() <= end) {
                foundTariffs.add(t);
            }
        }

        return foundTariffs;
    }

    public Element getXML() {

        Element operator = new Element("operator");

        Element elName = new Element(NAME);
        Element elAmount = new Element("amount");

        elName.appendChild(name);
        elAmount.appendChild(String.valueOf(getAmount()));

        Element elTariffs = new Element(TARIFFS);
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
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (clients - %d)", name, getAmount())).append('\n');
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
