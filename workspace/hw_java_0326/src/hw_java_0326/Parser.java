package hw_java_0326;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser {
	static class APT{
		String apt;
		String dong;
		String cash;
		
		APT(String apt, String dong, String cash){
			this.apt = apt;
			this.dong = dong;
			this.cash = cash;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File file = new File("./src/AptDealHistory.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		String input = sc.next();
		LinkedList<APT> data = new LinkedList<APT>();

		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();

			NodeList childNodes = root.getElementsByTagName("item");
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node n = childNodes.item(i);
				if (n.getNodeType() == n.ELEMENT_NODE) {
					Element ele = (Element) n;
					NodeList child = ele.getChildNodes();
					APT a = new APT("","","");
					for (int k = 0; k < child.getLength(); k++) {
						Node node2 = child.item(k);
						
						if (node2.getNodeType() == n.ELEMENT_NODE) {
							Element element = (Element)node2;
							String textContent = element.getTextContent();
							String nodeName = element.getNodeName();

							switch (nodeName) {
							case "법정동":
								a.dong = textContent;
								break;
							case "아파트":
								a.apt = textContent;
								break;
							case "거래금액":
								a.cash = textContent;
								break;								
							}
						}
					}
					data.add(a);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for(int i=0; i<data.size(); i++) {
			if(data.get(i).apt.contains(input)) {
				System.out.println("아파트: " + data.get(i).apt);
				System.out.println("법정동: " + data.get(i).dong);
				System.out.println("거래금액: " + data.get(i).cash);
			}
		}
	}
}
