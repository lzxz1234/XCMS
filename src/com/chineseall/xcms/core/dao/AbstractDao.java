package com.chineseall.xcms.core.dao;

import java.util.List;
import java.util.Map;

import com.chineseall.xcms.core.vo.Req;

public abstract class AbstractDao {
    
    protected Req req;
    
    public abstract Object get(long id);
    public abstract void add(Object target);
    public abstract void del(long id);
    public abstract void mod(Object target);
    public abstract List<?> qry(Map<String, String> params);
    public abstract int cnt(Map<String, String> params);
    
    public Req getReq() {
        return req;
    }
    public void setReq(Req req) {
        this.req = req;
    }
    
}
