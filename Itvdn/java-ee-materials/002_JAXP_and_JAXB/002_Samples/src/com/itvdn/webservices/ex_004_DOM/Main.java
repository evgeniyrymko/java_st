package com.itvdn.webservices.ex_004_DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Asus on 03.12.2017.
 */
public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);

        DocumentBuilder db = dbf.newDocumentBuilder();

        Document document = db.parse("D:\\Andrew\\CB\\Java EE (ITVDN)\\002_JAXP_and_JAXB\\002_Samples" +
                "\\src\\com\\itvdn\\webservices\\ex_004_DOM\\books.xml");

        Element root = document.getDocumentElement();

        System.out.println(root.getNodeName());
        System.out.println(root.getNodeType());


        NodeList list = root.getElementsByTagName("book");

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.println("Book name: " + root.getElementsByTagName("title").item(i).getFirstChild().getTextContent());
            System.out.println("Author name: " + root.getElementsByTagName("author").item(i).getFirstChild().getTextContent());
            System.out.println("ID: " + node.getAttributes().item(0).getNodeValue());
            System.out.println("ISBN: " + node.getAttributes().item(1).getNodeValue());
        }


    }

}
