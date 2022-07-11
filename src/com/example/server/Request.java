package com.example.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

public class Request {
    private String method;
    private String url;
    private String query;
    private InputStream is;
    private Map<String,List<String>> parameterMap;
    public Request(Socket client){
        parameterMap = new HashMap<>();
        try {
            is = client.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] flush = new byte[1024*1024];
        int len = 0;
        try {
            len = is.read(flush);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String msg = new String(flush, 0, len);
        System.out.println(msg);
        resolve(msg);
    }
    private void resolve(String msg){
        System.out.println("--------------");
        String[] str = msg.split(" ");
        method = str[0].toLowerCase();
        url = str[1];
        int idx = url.indexOf("?");
        if(idx >= 0 && idx < url.length()){
            query = url.substring(idx+1);
            url = url.substring(0, idx);
        }
        if(method.equals("post")){
            int idx1 = msg.lastIndexOf("\n");
            query = msg.substring(idx1+1);
        }
        System.out.println("url--->" + url);
        if(query != null){
            convertMap();
        }
    }
    private void convertMap(){
        String[] keyValues = query.split("&");
        for(String keyValue : keyValues){
            String[] kv = keyValue.split("=");
            kv = Arrays.copyOf(kv, 2);
            String key = kv[0] == null ? null : decoder(kv[0], "UTF-8");
            String value = kv[1] == null ? null : decoder(kv[1], "UTF-8");

            if(!parameterMap.containsKey(key)){
                parameterMap.put(key, new ArrayList<>());
            }
            parameterMap.get(key).add(value);
        }
        Set<String> set = parameterMap.keySet();
        for(String s : set){
            for(String t : parameterMap.get(s)){
                System.out.println(s + " ---> " + t);
            }
        }
    }

    private String decoder(String msg, String enc) {
        try {
            return java.net.URLDecoder.decode(msg, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] getParameterValues(String key){
        List<String> values = parameterMap.get(key);
        if(values == null || values.size() == 0){
            return null;
        }
        return values.toArray(new String[0]);
    }
    public String getParameterValue(String key){
        String[] values = getParameterValues(key);
        return values == null ? null : values[0];
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getQuery() {
        return query;
    }
}
