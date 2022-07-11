package com.example.server;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {
    private static WebContext webContext;
    static {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            WebHandler handle = new WebHandler();
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/example/server/web.xml"), handle);
            webContext = new WebContext(handle.getEntities(), handle.getMappings());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Servlet getServletFromUrl(String url) {
        try {
            String className = webContext.getClz(url);
            Class clz = Class.forName(className);
            Servlet servlet = (Servlet)clz.getConstructor().newInstance();
            return servlet;
        } catch (Exception e) {
            return null;
//            e.printStackTrace();
        }
    }
}
