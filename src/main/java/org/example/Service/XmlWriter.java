package org.example.Service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Class for writing to a file in html format
 */

public class XmlWriter {
    /**
     * Method for writing statistics to HML format
     * @param map Map with values for statistics
     * @param path Path where to write the file
     */
    public void write(Map<String,Integer> map, String path){
        DocumentBuilderFactory  factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("statistics");

           document.appendChild(root);

            for (Map.Entry<String,Integer> entry :map.entrySet()) {
                Element item = document.createElement("item");
                Text valueText = document.createTextNode(entry.getKey());
                Element value = document.createElement("value");
                value.appendChild(valueText);
                Text countText = document.createTextNode(entry.getValue().toString());
                Element count = document.createElement("count");
                count.appendChild(countText);
                item.appendChild(value);
                item.appendChild(count);
                root.appendChild(item);
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT,"yes");
                transformer.transform(new DOMSource(document),new StreamResult(new FileOutputStream(path)));
            }
        }
        catch (ParserConfigurationException | IOException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
