package com.chineseall.xcms.nb.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.util.cri.SimpleCriteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.lang.Each;
import org.nutz.lang.Lang;

import com.chineseall.xcms.core.dao.AbstractDao;

public class NutzDao<T> extends AbstractDao<T> {

    private static final Logger log = Logger.getLogger(NutDao.class);
    
    private static NutDao dao = new NutDao();
    static {
        try {
            SimpleDataSource ds = new SimpleDataSource();
            ds.setDriverClassName("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://118.192.46.48:8080/siwei?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8");
            ds.setUsername("siwei");
            ds.setPassword("siwei1234");
            dao.setDataSource(ds);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    @Override
    public T get(long id) {

        return dao.fetch(this.req.getEntityClass(), id);
    }
    
    @Override
    public void add(T target) {
        
        dao.insert(target);
    }

    @Override
    public void del(long id) {
        
        dao.delete(this.req.getEntityClass(), id);
    }

    @Override
    public void mod(T target) {
        
        dao.update(target);
    }

    @Override
    public List<T> qry(Map<String, String> params) {
        
        final SimpleCriteria cnd = Cnd.cri();
        final SqlExpressionGroup where = cnd.where();
        cnd.setPager(new Pager());
        if(params != null) 
            Lang.each(params, new Each<Entry<String, String>>() {
                @Override
                public void invoke(int indx, Entry<String, String> ele, int len){
                    String key = ele.getKey();
                    String value = ele.getValue();
                    if(key.startsWith("[GT]") && value.length() > 0) 
                        where.andGT(key.substring(4), Long.parseLong(value));
                    else if(key.startsWith("[LT]") && value.length() > 0)
                        where.andLT(key.substring(4), Long.parseLong(value));
                    else if(key.startsWith("[EQ]") && value.length() > 0)
                        where.andEquals(key.substring(4), value);
                    else if(key.startsWith("[LK]") && value.length() > 0)
                        where.andLike(key.substring(4), value);
                    else if(key.startsWith("[ASC]") && value.length() > 0)
                        cnd.asc(key.substring(5));
                    else if(key.startsWith("[DSC]") && value.length() > 0)
                        cnd.desc(key.substring(5));
                    else if(key.equals("pageSize"))
                        cnd.getPager().setPageSize(Integer.parseInt(value));
                    else if(key.equals("pageNo"))
                        cnd.getPager().setPageNumber(Integer.parseInt(value));
                    else if(value.length() == 0)
                        log.debug(String.format("[无效的参数：%s-%s]", key, value));
                    else 
                        log.info(String.format("[不可识别的参数：%s-%s]", key, value));
                }
            });
        return dao.query(this.req.getEntityClass(), cnd);
    }

    @Override
    public int cnt(Map<String, String> params) {
        
        final SimpleCriteria cnd = Cnd.cri();
        final SqlExpressionGroup where = cnd.where();
        if(params != null) 
            Lang.each(params, new Each<Entry<String, String>>() {
                @Override
                public void invoke(int indx, Entry<String, String> ele, int len){
                    String key = ele.getKey();
                    String value = ele.getValue();
                    if(key.startsWith("[GT]") && value.length() > 0) 
                        where.andGT(key.substring(4), Long.parseLong(value));
                    else if(key.startsWith("[LT]") && value.length() > 0)
                        where.andLT(key.substring(4), Long.parseLong(value));
                    else if(key.startsWith("[EQ]") && value.length() > 0)
                        where.andEquals(key.substring(4), value);
                    else if(key.startsWith("[LK]") && value.length() > 0)
                        where.andLike(key.substring(4), value);
                    else if(key.startsWith("[ASC]") && value.length() > 0)
                        cnd.asc(key.substring(5));
                    else if(key.startsWith("[DSC]") && value.length() > 0)
                        cnd.desc(key.substring(5));
                }
            });
        return dao.count(this.req.getEntityClass(), cnd);
    }

}
