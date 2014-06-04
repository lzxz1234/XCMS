/*
 * @title: BaseDomain.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 上午10:02:47
 * @version V1.0
 */
package com.siwei.domain;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.nutz.resource.Scans;

/**
 * @class BaseDomain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
public class Domain {

    private static ConcurrentHashMap<String, Class<?>> pool = new ConcurrentHashMap<String, Class<?>>();
    static {
        List<Class<?>> classList = Scans.me().scanPackage(Domain.class);
        for(Class<?> clazz : classList) {
            pool.put(clazz.getSimpleName().toLowerCase(), clazz);
        }
    }
    
    public static Class<?> getBySimpleNameIgnoreCase(String className) {
        
        return pool.get(className);
    }
    
}
