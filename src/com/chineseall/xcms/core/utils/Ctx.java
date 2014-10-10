package com.chineseall.xcms.core.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

public class Ctx {
    
    private static Logger log = Logger.getLogger(Ctx.class);
    
    private static Map<String, Object> globalSettings = new ConcurrentHashMap<String, Object>();
    private static volatile ThreadLocal<Map<String, Object>> tl = 
            new ThreadLocal<Map<String, Object>>();
    
    public static Map<String, Object> getCtx() {
        
        Map<String, Object> map = tl.get();
        if(map == null) {
            synchronized(tl) {
                if(map == null) {
                    map = new ConcurrentHashMap<String, Object>(globalSettings);
                    tl.set(map);
                }
            }
        }
        return map;
    }
    
    public static void setGlobal(String key, Object value) {
        
        log.warn(String.format("[系统添加新的默认属性：%s - %s]", key, value));
        globalSettings.put(key, value);
    }
    
    public static void set(String key, Object value) {
        
        getCtx().put(key, value);
    }
    
    public static Object get(String key) {
        
        return getCtx().get(key);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> clazz, String key) {
        
        return (T)get(key);
    }
    
    public static void translate(Trs target) {
        
        Iterator<Entry<String, Object>> it = getCtx().entrySet().iterator();
        Entry<String, Object> entry = null;
        while(it.hasNext()) {
            entry = it.next();
            target.trs(entry.getKey(), entry.getValue());
        }
    }
    
    public static interface Trs {
        public void trs(String key, Object value);
    }
}
