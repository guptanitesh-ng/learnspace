package com.concepts.xml;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ParseXMLAsString {

    public static void main(String[] args) throws Exception {
        String xmlContent = "<data><template><field name=\"ConfigServer\" value=\"rmi://10.56.31.156:10000/ConfigurationServer\"/><field name=\"DeployAgent\" value=\"10.56.26.202\"/><field name=\"DeployName\" value=\"dev-tmengine-cdi\"/><field name=\"DeployVersion\" value=\"1038\"/><field name=\"Extraction\" value=\"UNKNOWN\"/><field name=\"ExtractionEndDate\" value=\"2016-01-26T06:56:59\"/><field name=\"ExtractionStartDate\" value=\"2016-01-26T05:43:03\"/><field name=\"TemplateVersion\" value=\"landc-install-escription-4.40.2_2.9.0\"/><field name=\"Version\" value=\"landc-install-escription-4.40.2\"/></template></data>";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlContent));
            try {
                Document doc = db.parse(is);
                Node tempNode = doc.getDocumentElement().getChildNodes().item(0);
                NodeList childNodes = tempNode.getChildNodes();
                for (int index = 0; index < childNodes.getLength(); index++) {
                    Node node = childNodes.item(index);
                    NamedNodeMap attributes = node.getAttributes();
                    if ("Version".equals(attributes.getNamedItem("name").getNodeValue())) {
                        System.out.println(attributes.getNamedItem("value").getNodeValue());
                    }
                }
            }
            catch (SAXException e) {
                // handle SAXException
            }
            catch (IOException e) {
                // handle IOException
            }
        }
        catch (ParserConfigurationException e1) {
            // handle ParserConfigurationException
        }
    }
}
