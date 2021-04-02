package xml;

import java.io.File;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.graalvm.compiler.graph.NodeList;

import com.sun.java.util.jar.pack.Attribute.Layout.Element;
import com.sun.org.apache.bcel.internal.classfile.Node;

public class VirusReportDomTest {
	public static void main(String[] args) {
		File file = new File("./src/xml/virus-report.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstanc();
		DocumentBuilder builder;
		
		try {
	        builder = factory.newDocumentBuilder();
	        Document doc = (Document) builder.parse(file);
	        ((org.w3c.dom.Node) doc.getDefaultRootElement()).normalize();
	        Element root = doc.getDefaultRootElement();
	        System.out.println("Root element: " + root.getNodeName());

	        NodeList childNodes = root.getChildNodes();
	        for (int i = 0; i < childNodes.getLength(); i++) {
	            Node node = childNodes.item(i);

	            if (node.getNodeType() == node.ELEMENT_NODE) {
	                Element element = (Element) node;

	                String textContent = element.getTextContent();
	                String nodeName = element.getNodeName();

	                switch (nodeName) {
	                case "author":
	                    System.out.println("author: " + textContent);
	                    break;
	                case "about":
	                    System.out.println("about: " + textContent);
	                    break;
	                case "date":
	                    NodeList dateChildNodes = element.getChildNodes();
	                    for (int j = 0; j < dateChildNodes.getLength(); j++) {
	                        Node childNode = dateChildNodes.item(j);
	                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
	                            Element childElement = (Element) childNode;
	                            String childTextContent = childElement.getTextContent();
	                            String childNodeName = childElement.getNodeName();
	                            switch (childNodeName) {
	                            case "year":
	                                System.out.println("date-year: "+childTextContent);
	                                break;
	                            case "month":
	                                System.out.println("date-month: "+childTextContent);
	                                break;
	                            case "day" :
	                                System.out.println("date-day: "+childTextContent);
	                                break;
	                            }
	                        }
	                    }
	                }

	            }
	        }
	    } catch (Exception e) {
	        // TODO: handle exception
	    }
	}
}
