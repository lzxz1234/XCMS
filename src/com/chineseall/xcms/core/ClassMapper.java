package com.chineseall.xcms.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SymbolName到真实类对应关系
 */
public class ClassMapper {

    private Map<String, Class<?>> domainMaps = new ConcurrentHashMap<String, Class<?>>();
    
    @SuppressWarnings("unchecked")
    public <T> Class<T> findClass(String symbolName) {
        
        return (Class<T>) domainMaps.get(symbolName);
    }
    
    public List<String> getAllClassSymbols() {
        
        return new ArrayList<String>(domainMaps.keySet());
    }
    
    public void putClass(String symbolName, Class<?> clazz) {
        
        domainMaps.put(symbolName, clazz);
    }
    
}
