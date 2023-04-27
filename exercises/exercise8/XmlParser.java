import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;

public class XmlParser {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("myxml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("Book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element bookElement = (Element) nodeList.item(i);
                System.out.println("Title: " + bookElement.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Published Year: " + bookElement.getElementsByTagName("publishedYear").item(0).getTextContent());
                System.out.println("Number of Pages: " + bookElement.getElementsByTagName("numberOfPages").item(0).getTextContent());
                NodeList authorsList = bookElement.getElementsByTagName("author");
                System.out.print("Authors: ");
                for (int j = 0; j < authorsList.getLength(); j++) {
                    Element authorElement = (Element) authorsList.item(j);
                    System.out.print(authorElement.getTextContent() + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

