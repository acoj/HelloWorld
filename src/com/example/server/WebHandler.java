package com.example.server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class WebHandler extends DefaultHandler {
    private List<Entity> entities = new ArrayList<>();;
    private List<Mapping> mappings = new ArrayList<>();;
    private Entity entity;
    private Mapping mapping;
    private String tag;
    private boolean isMapping = false;

    public List<Entity> getEntities() {
        return entities;
    }
    public List<Mapping> getMappings() {
        return mappings;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tag = qName;
        if(qName.equals("servlet")){
            isMapping = false;
            entity = new Entity();
        }else if(qName.equals("servlet-mapping")){
            isMapping = true;
            mapping = new Mapping();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if(tag != null){
            if(!isMapping){
                if(tag.equals("servlet-name")){
                    entity.setName(contents);
                }else if(tag.equals("servlet-class")){
                    entity.setClz(contents);
                }
            }else{
                if(tag.equals("servlet-name")){
                    mapping.setName(contents);
                }else if(tag.equals("url-pattern")){
                    mapping.addPatterns(contents);
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("servlet")){
            entities.add(entity);
        }else if(qName.equals("servlet-mapping")){
            mappings.add(mapping);
        }
        tag = null;
    }
}
