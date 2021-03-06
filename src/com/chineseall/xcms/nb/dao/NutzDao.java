package com.chineseall.xcms.nb.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.util.cri.SimpleCriteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.lang.Each;

import com.chineseall.xcms.core.dao.AbstractDao;
import com.chineseall.xcms.core.utils.DataSourceUtils;
import com.chineseall.xcms.core.utils.Lang;

public class NutzDao extends AbstractDao {

    private static final Logger log = Logger.getLogger(NutDao.class);
    protected static final NutDao dao = new NutDao(DataSourceUtils.getDataSource());
    
    @Override
    public Object get(long id) {

        return dao.fetch(this.req.getEntityClass(), id);
    }
    
    @Override
    public void add(Object target) {
        
        dao.insert(target);
    }

    @Override
    public void del(long id) {
        
        dao.delete(this.req.getEntityClass(), id);
    }

    @Override
    public void mod(Object target) {
        
        dao.update(target);
    }

    @Override
    public List<?> qry(Map<String, String> params) {
        
        final SimpleCriteria cnd = Cnd.cri();
        final SqlExpressionGroup where = cnd.where();
        cnd.setPager(new Pager());
        if(params != null) 
            Lang.each(params, new Each<Entry<String, String>>() {
                @Override
                public void invoke(int indx, Entry<String, String> ele, int len){
                    String key = ele.getKey();
                    String value = ele.getValue();
                    if(key.startsWith("_GT_") && value.length() > 0) 
                        where.andGT(key.substring(4), Long.parseLong(value));
                    else if(key.startsWith("_LT_") && value.length() > 0)
                        where.andLT(key.substring(4), Long.parseLong(value));
                    else if(key.startsWith("_EQ_") && value.length() > 0)
                        where.andEquals(key.substring(4), value);
                    else if(key.startsWith("_LK_") && value.length() > 0)
                        where.andLike(key.substring(4), value);
                    else if(key.startsWith("_ASC_") && value.length() > 0)
                        cnd.asc(key.substring(5));
                    else if(key.startsWith("_DSC_") && value.length() > 0)
                        cnd.desc(key.substring(5));
                    else if(key.equals("pageSize"))
                        cnd.getPager().setPageSize(Integer.parseInt(value));
                    else if(key.equals("pageNo"))
                        cnd.getPager().setPageNumber(Integer.parseInt(value));
                    else if(value.length() == 0)
                        log.debug(String.format("[无效的参数：%s-%s]", key, value));
                    else if(!"_".equals(key))//不打印ajax提交中的时间参数
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
                    if(key.startsWith("_GT_") && value.length() > 0) 
                        where.andGT(key.substring(4), Long.parseLong(value));
                    else if(key.startsWith("_LT_") && value.length() > 0)
                        where.andLT(key.substring(4), Long.parseLong(value));
                    else if(key.startsWith("_EQ_") && value.length() > 0)
                        where.andEquals(key.substring(4), value);
                    else if(key.startsWith("_LK_") && value.length() > 0)
                        where.andLike(key.substring(4), value);
                }
            });
        return dao.count(this.req.getEntityClass(), cnd);
    }

}
