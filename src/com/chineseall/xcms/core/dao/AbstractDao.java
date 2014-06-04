package com.chineseall.xcms.core.dao;

import java.util.List;
import java.util.Map;

import com.chineseall.xcms.core.vo.Req;

public abstract class AbstractDao<T> {
    
    protected Req<T> req;
    
    public abstract T get(long id);
    public abstract void add(T target);
    public abstract void del(long id);
    public abstract void mod(T target);
    public abstract List<T> qry(Map<String, String> params);
    public abstract int cnt(Map<String, String> params);
    
    public Req<T> getReq() {
        return req;
    }
    public void setReq(Req<T> req) {
        this.req = req;
    }
    
}
