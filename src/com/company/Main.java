package com.company;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        boolean isX = false;
        boolean isY = false;

        XMLInputFactory factory = XMLInputFactory.newFactory();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("src/com/company/points"));
            while (reader.hasNext()) {
                int res = reader.next();
                if (res == reader.START_ELEMENT) {
                    if (reader.getLocalName().equals("x"))
                        isX = true;
                    else if (reader.getLocalName().equals("y"))
                        isY = true;
                } else if (res == reader.CHARACTERS) {
                    if (isX) {
                        System.out.print(reader.getText() + "px, ");
                        isX = false;
                    } else if (isY) {
                        System.out.print(reader.getText() + "px" + "\n");
                        isY = false;
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

    }
}
