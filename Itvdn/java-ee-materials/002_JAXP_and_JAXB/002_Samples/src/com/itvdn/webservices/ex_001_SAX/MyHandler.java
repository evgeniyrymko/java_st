package com.itvdn.webservices.ex_001_SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Asus on 27.11.2017.
 */
public class MyHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);


        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Attribute: " + attributes.getQName(i) + " " + attributes.getValue(i));
        }


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

}
