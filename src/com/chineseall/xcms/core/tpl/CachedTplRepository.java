package com.chineseall.xcms.core.tpl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.chineseall.xcms.core.vo.Req;

/**
 * 每次缓存有效时间五分钟
 */
public class CachedTplRepository extends TplRepository {

    private final int AvaliableTime = 5 * 60 * 1000;
    private ConcurrentHashMap<String, CacheHolder> viewCache = new ConcurrentHashMap<String, CacheHolder>();
    private final TplRepository realViewRepository;
    
    public CachedTplRepository(TplRepository realViewRepository) {
        
        this.realViewRepository = realViewRepository;
    }
    
    @Override
    public String getView(Req<?> req, Type type) {

        if(req == null || type == null) return "";

        String entityName = req.getEntiryClassName();
        String viewIdentifier = entityName + "@" + type;
        CacheHolder result = viewCache.get(viewIdentifier);
        if(result == null || System.currentTimeMillis() - result.time > AvaliableTime) {
            result = new CacheHolder(realViewRepository.getView(req, type));
            if(result.content != null) viewCache.put(viewIdentifier, result);
        }
        return result.content;
    }

    private static class CacheHolder {
        final String content;
        final long time;
        
        CacheHolder(String content) {
            this(System.currentTimeMillis(), content);
        }
        CacheHolder(long time, String content) {
            this.content = content;
            this.time = time;
        }
    }

    @Override
    public String getIndexView(List<String> symbolList) {
        
        return this.realViewRepository.getIndexView(symbolList);
    }
    
}
