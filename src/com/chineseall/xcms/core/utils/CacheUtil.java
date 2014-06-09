package com.chineseall.xcms.core.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CacheUtil<K, V> {

    private final long validTime;//有效时间
    private final Map<K, CacheHolder<V>> map;

    public CacheUtil(long validTime) {
        
        this.validTime = validTime;
        this.map = new ConcurrentHashMap<>();
    }
    
    public final V get(K key) {
        
        CacheHolder<V> resultHolder = map.get(key);
        return System.currentTimeMillis() - resultHolder.putTime > validTime ? null : resultHolder.v;
    }
    
    public final V put(K key, V value) {
        
        CacheHolder<V> priviousHolder = map.put(key, new CacheHolder<V>(value));
        return priviousHolder == null ? null : priviousHolder.v;
    }
    
    private static class CacheHolder<V> {
        final V v;
        final long putTime;
        public CacheHolder(V v) {
            this.v = v;
            this.putTime = System.currentTimeMillis();
        }
    }
}
