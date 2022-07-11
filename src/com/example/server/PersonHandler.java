package com.example.server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PersonHandler extends DefaultHandler {
    private List<Person> persons;
    private Person person;
    private String tag;

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("resolve document start");
        persons = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + ": " + "resolve start");
        tag = qName;
        if(qName.equals("person")){
            person = new Person();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if(contents.length() > 0){
            System.out.println("contents: " + contents);
        }else{
            System.out.println("contents: " + "null");
        }
        if(tag != null){
            if(tag.equals("name")){
                person.setName(contents);
            } else if(tag.equals("age")){
                person.setAge(Integer.valueOf(contents));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + ": " + "resolve end");
        if(qName.equals("person")){
            persons.add(person);
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("resolve document end");
    }

}

class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}