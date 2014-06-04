package com.chineseall.xcms.core.dao;

import com.chineseall.xcms.core.utils.Cfg;
import com.chineseall.xcms.core.vo.Req;


public class DaoFactory {
    
    private Cfg cfg = Cfg.getCfg("class2dao.properties");
    private String defaultDaoClass;
    
    @SuppressWarnings("unchecked")
    public <T> AbstractDao<T> getDao(Req<T> req) {
        
        String daoClass = cfg.getProperty(req.getEntiryClassName(), defaultDaoClass);
        AbstractDao<T> result;
        try {
            result = (AbstractDao<T>) Class.forName(daoClass).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("构造Dao失败", e);
        }
        result.setReq(req);
        return (AbstractDao<T>)result;
    }
    
    public void setDefaultDaoClass(String defaultDaoClass) {
        this.defaultDaoClass = defaultDaoClass;
    }
    
}
