package com.chineseall.xcms.core.dao;

import com.chineseall.xcms.core.utils.Cfg;
import com.chineseall.xcms.core.vo.Req;

public class DaoFactory {
    
    private Cfg cfg = Cfg.getCfg("class2dao.properties");
    private String defaultDaoClass;
    
    public AbstractDao getDao(Req req) {
        
        String daoClass = cfg.getProperty(req.getEntityClassName(), defaultDaoClass);
        AbstractDao result;
        try {
            result = (AbstractDao) Class.forName(daoClass).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("构造Dao失败", e);
        }
        result.setReq(req);
        return (AbstractDao)result;
    }
    
}
