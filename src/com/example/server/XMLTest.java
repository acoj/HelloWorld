package com.example.server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class XMLTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
//        PersonHandler handle = new PersonHandler();
//        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/example/server/p.xml"), handle);
        WebHandler handle = new WebHandler();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/example/server/web.xml"), handle);

        System.out.println("--------------------------");
        //System.out.println(Integer.valueOf(""));
        /*List<Person> persons = handle.getPersons();
        for(Person person : persons){
            System.out.println(person.toString());
        }*/
        /*List<Entity> entities = handle.getEntities();
        System.out.println(entities.size());
        for(Entity entity : entities){
            System.out.println(entity.toString());
        }
        List<Mapping> mappings = handle.getMappings();
        for(Mapping mapping : mappings){
            System.out.println(mapping.toString());
        }*/

        WebContext context = new WebContext(handle.getEntities(), handle.getMappings());
        String className = context.getClz("/login");
        Class clz = Class.forName(className);
        Servlet servlet = (Servlet)clz.getConstructor().newInstance();
        System.out.println(servlet);
        //servlet.service();
    }
}

