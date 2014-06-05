package com.chineseall.xcms.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SymbolName到真实类对应关系
 */
public class ClassMapper {

    private Class<?> defaultClass;
    private Map<String, Class<?>> domainMaps = new ConcurrentHashMap<String, Class<?>>();
    
    public Class<?> findClass(String symbolName) {
        
        Class<?> result = domainMaps.get(symbolName);
        return result == null ? defaultClass : result;
    }
    
    public List<String> getAllClassSymbols() {
        
        return new ArrayList<String>(domainMaps.keySet());
    }
    
    public void putClass(String symbolName, Class<?> clazz) {
        
        domainMaps.put(symbolName, clazz);
    }
    
    public void setDefaultClass(Class<?> defaultClass) {
        
        this.defaultClass = defaultClass;
    }
}
