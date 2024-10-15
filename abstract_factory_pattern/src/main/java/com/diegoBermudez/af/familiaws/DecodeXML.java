package com.diegoBermudez.af.familiaws;


import com.diegoBermudez.af.IDecoding;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DecodeXML implements IDecoding {

    private static DecodeXML instance = new DecodeXML();

    private DecodeXML(){}

    public static DecodeXML getInstance(){
        return instance;
    }

    @Override
    public String[] decode(String xml, String attribute){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new java.io.ByteArrayInputStream(xml.getBytes()));

            Element root = document.getDocumentElement();

            NodeList nodes = root.getElementsByTagName(attribute);
            String[] stringNodes = new String[nodes.getLength()];
            for(int i = 0; i < nodes.getLength(); i++){
                stringNodes[i] = nodes.item(i).getTextContent();
            }
            return stringNodes;
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
