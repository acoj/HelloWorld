package com.example.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebContext {
    private Map<String, String> mapEntities = new HashMap<>();
    private Map<String, String> mapMappings = new HashMap<>();
    public WebContext(List<Entity> entities, List<Mapping> mappings){
        for(Entity entity : entities){
            mapEntities.put(entity.getName(), entity.getClz());
        }
        for(Mapping m : mappings){
            for(String p : m.getPatterns())
            mapMappings.put(p, m.getName());
        }
    }
    public String getClz(String pattern){
        Set<String> set = mapEntities.keySet();
        for(String s : set){
            System.out.println(s + " --> " + mapEntities.get(s));
        }
        set = mapMappings.keySet();
        for(String s : set){
            System.out.println(s + " --> " + mapMappings.get(s));
        }
        return mapEntities.get(mapMappings.get(pattern));
    }
}
