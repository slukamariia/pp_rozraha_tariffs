package tariffs.model;

import nu.xom.Element;

public class Client implements XMLSerializable {

    public static final String NUMBER = "number";

    public void setNumber(String number) {
        this.number = number;
    }

    private String number;

    public Client(String number) {
        this.number = number;
    }

    public Client(Element elNumber) {
        this.number = elNumber.getValue();
    }

    public Element getXML() {
        Element elNumber = new Element(NUMBER);
        elNumber.appendChild(number);

        return elNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "number='" + number + '\'' +
                '}';
    }
}
