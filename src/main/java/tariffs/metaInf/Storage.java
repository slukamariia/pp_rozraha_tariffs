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

    //todo: add operator
    public void addOperator(Operator operator) {
        operators.add(operator);
    }

    //todo: get all information
    public List<Operator> getAllOperators() {
         return operators;
    }

    //todo: get tariffs

    //todo: get tariffs with external information

    //todo: get amount of clients

    //todo: get tariffs of range

    //todo: add tariff to an operator (at the end: SAVE)

    //todo: edit tariff to an operator (at the end: SAVE)

    //todo: delete tariff to an operator (at the end: SAVE)

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