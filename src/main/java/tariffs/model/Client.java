package tariffs.model;

import nu.xom.Element;

public class Client implements XMLSerializable {

    private String number;

    public Client(String number) {
        this.number = number;
    }

    public Element getXML() {
        Element number = new Element("number");
        number.appendChild(number);
        return number;
    }
}
