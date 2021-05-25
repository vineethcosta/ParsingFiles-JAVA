package parsingFile;

import card.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class xmlParser extends fileDescription implements parser{
    public xmlParser(String sourceFile, String destinationFile, String extension) {
        super(sourceFile, destinationFile, extension);
    }


    @Override
    public List<ICreditCard> fileParser(String nameOfFile)  {
        try {

            File xmlSourceFile = new File(nameOfFile);
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(xmlSourceFile);
            doc.getDocumentElement().normalize();
            List<ICreditCard> creditCardsList = new ArrayList<>();
            NodeList cardRows = doc.getElementsByTagName("row");
            for (int i = 0; i < cardRows.getLength(); i++) {
                Node cardNode = cardRows.item(i);
                if (cardNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) cardNode;
                    Node cardNumberNode = elem.getElementsByTagName("CardNumber").item(0);
                    String CardNumber = cardNumberNode.getTextContent();

                    Node expiryDateNode = elem.getElementsByTagName("ExpirationDate").item(0);
                    String ExpirationDate = expiryDateNode.getTextContent();

                    Node nameOfCardHolderNode = elem.getElementsByTagName("NameOfCardholder").item(0);
                    String NameOfCardholder = nameOfCardHolderNode.getTextContent();
                    creditCardsList.add(CreditCardHandleGet.getCardType(CardNumber,ExpirationDate,NameOfCardholder));
                }
            }
            this.setAllCards(creditCardsList);
            return creditCardsList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void fileWriter( String target) {
        List<ICreditCard> creditCards = this.getAllCreditCards();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentFactory = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentFactory.newDocument();

            Element root = doc.createElementNS("", "root");
            doc.appendChild(root);

            for (ICreditCard creditCard : creditCards) {
                root.appendChild(createRow(doc, creditCard.getCardNumber(), creditCard.getCardType()));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(doc);

            File myFile = new File(target);

            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(myFile);

            transformer.transform(source, console);
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node createRow(Document doc, String CardNumber, String type) {
        Element row = doc.createElement("row");
        row.appendChild(createUserElement(doc, "CardNumber", CardNumber));
        row.appendChild(createUserElement(doc, "Type", type));
        return row;
    }

    private static Node createUserElement(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}
