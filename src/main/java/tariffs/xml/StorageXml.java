package tariffs.xml;

import tariffs.metaInf.Operators;
import tariffs.model.Operator;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StorageXml implements Storage {
    private final static String PACKAGE_GENERATED_SOURCE = "tariffs.config.model";
    private final static String XSD_NAME = "/mobile.xsd";
    private final static String XML_NAME = "/mobile.xml";
    private List<Operator> operators = new ArrayList<>();

    /*public StorageXml() throws Exception {
        initData();
    }

    private void initData() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(PACKAGE_GENERATED_SOURCE);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        URL xsdUrl = getClass().getResource(XSD_NAME);
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(xsdUrl);
        unmarshaller.setSchema(schema);
        Operators unmarshal = (Operators) unmarshaller.unmarshal(getClass().getResource(XML_NAME));
        operators.addAll(unmarshal.getOperator());
    }*/

    @Override
    public List<Operator> getOperators() {
        return operators;
    }
}
