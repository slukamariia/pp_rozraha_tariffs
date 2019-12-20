package tariffs.metaInf;

import nu.xom.*;
import tariffs.model.Operator;
import tariffs.model.Tariff;

import java.io.*;
import java.util.*;


public class Storage {

    private List<Operator> operators;
    private String fileName;

    public Storage(String fileName) {
        this.fileName = fileName;
        operators = new LinkedList<Operator>();

        try {
            readData();
        } catch (ParsingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Storage(){
        operators = new LinkedList<>();
    }

    //add operator
    public void addOperator(Operator operator) {
        operators.add(operator);
    }

    //remove operator
    public void removeOperator(int index) {
        this.operators.remove(index);
    }

    //get all information
    public List<Operator> getAllOperators() {
        return operators;
    }

    //get tariffs
    public List<Tariff> getTariff(int index) {
        return operators.get(index).getTariffs();
    }

    //get amount of clients
    public Integer getAmountOfClients() {
        Integer sum = 0;
        for (Operator o : operators) {
            sum += o.getAmount();
        }
        return sum;
    }

    //get tariffs of range
    public List<Tariff> getTariffInRange(int index, int st, int end) {
        return operators.get(index).getInRange(st, end);
    }

    //add tariff to an operator (at the end: SAVE)
    public boolean addTariff(int index, Tariff tariff) {
        operators.get(index).getTariffs().add(tariff);
        save();
        return true;
    }

    //delete tariff to an operator (at the end: SAVE)
    public boolean removeTariff(int operatorIndex, int tariffIndex) {
        this.operators.get(operatorIndex).getTariffs().remove(tariffIndex);
        return true;
    }

    private void readData() throws ParsingException, IOException {

        try {
            File file = new File(fileName);
            if(!file.exists()) {
                //make structure for file
                save();
            }

            Document doc = new Builder().build(fileName);

            Elements elOperators = doc.getRootElement().getChildElements();

            for(int i = 0, n = elOperators.size(); i < n; i++) {
                Element elOperator = elOperators.get(i);
                operators.add(new Operator(elOperator));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void save() {

        Element root = new Element("mobile");
        for(Operator o: operators) {
            root.appendChild(o.getXML());
        }


        try {
            Document doc = new Document(root);
            format(new BufferedOutputStream(new FileOutputStream(fileName)), doc);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void format(OutputStream os, Document doc) throws IOException {
        Serializer serializer= new Serializer(os,"ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

}