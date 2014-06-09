package com.chineseall.xcms.core.tpl;

import java.util.List;

import com.chineseall.xcms.core.utils.CacheUtil;
import com.chineseall.xcms.core.vo.Req;

/**
 * 每次缓存有效时间五分钟
 */
public class CachedTplRepository extends TplRepository {

    private final int AvaliableTime = 5 * 60 * 1000;
    private CacheUtil<String, String> viewCache = new CacheUtil<>(AvaliableTime);
    private final TplRepository realViewRepository;
    
    public CachedTplRepository(TplRepository realViewRepository) {
        
        this.realViewRepository = realViewRepository;
    }
    
    @Override
    public String getView(Req req, Type type) {

        if(req == null || type == null) return "";

        String entityName = req.getEntityClassName();
        String viewIdentifier = entityName + "@" + type;
        String result = viewCache.get(viewIdentifier);
        if(result == null) {
            result = realViewRepository.getView(req, type);
            if(result != null) viewCache.put(viewIdentifier, result);
        }
        return result;
    }

    @Override
    public String getIndexView(List<String> symbolList) {
        
        return this.realViewRepository.getIndexView(symbolList);
    }
    
}
