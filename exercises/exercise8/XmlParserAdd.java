import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
public class XmlParserAdd {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("myxml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Add new book entry
            Element newBookElement = doc.createElement("Book");
            Element newTitleElement = doc.createElement("title");
            newTitleElement.appendChild(doc.createTextNode("How to Stop Worrying and Start Living (Dale Carnegie Books)"));
            Element newPublishedYearElement = doc.createElement("publishedYear");
            newPublishedYearElement.appendChild(doc.createTextNode("2004"));
            Element newNumberOfPagesElement = doc.createElement("numberOfPages");
            newNumberOfPagesElement.appendChild(doc.createTextNode("320"));
            Element newAuthorsElement = doc.createElement("authors");
            Element newAuthorElement = doc.createElement("author");
            newAuthorElement.appendChild(doc.createTextNode("Dale Carnegie"));
            newAuthorsElement.appendChild(newAuthorElement);
            newBookElement.appendChild(newTitleElement);
            newBookElement.appendChild(newPublishedYearElement);
            newBookElement.appendChild(newNumberOfPagesElement);
            newBookElement.appendChild(newAuthorsElement);
            doc.getDocumentElement().appendChild(newBookElement);

            // Print updated document
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


