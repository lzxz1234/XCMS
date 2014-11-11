package com.chineseall.xcms.core.dao;

import com.chineseall.xcms.core.vo.Req;

public class DaoFactory {
    
    private DaoLoader[] loadList;
    
    public AbstractDao getDao(Req req) {
        
        if(loadList != null)
            for(DaoLoader loader : loadList)
                if(loader.getDao(req) != null)
                    return loader.getDao(req);
        return null;
    }
    
    public static interface DaoLoader {
        
        public AbstractDao getDao(Req req);
        
    }
    
}
