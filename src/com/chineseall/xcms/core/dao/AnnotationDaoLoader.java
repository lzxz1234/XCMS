/**
 * XCMS
 * @title AnnotationDaoLoader.java
 * @package com.chineseall.xcms.core.dao
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月11日-下午2:53:51
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chineseall.xcms.core.dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.nutz.resource.Scans;

import com.chineseall.xcms.core.dao.DaoFactory.DaoLoader;
import com.chineseall.xcms.core.vo.Req;

/**
 * @class AnnotationDaoLoader
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class AnnotationDaoLoader implements DaoLoader {

    private Map<String, Class<? extends AbstractDao>> map = new ConcurrentHashMap<>();
    private String scanPackage;
    
    @SuppressWarnings("unchecked")
    public void init() {
        
        map.clear();
        List<Class<?>> classList = Scans.me().scanPackage(scanPackage);
        for(Class<?> clazz : classList) {
            if(AbstractDao.class.isAssignableFrom(clazz) &&
                    clazz.isAnnotationPresent(Dao.class)) {
                
                Dao daoAnno = clazz.getAnnotation(Dao.class);
                map.put(daoAnno.symbol(), (Class<? extends AbstractDao>) clazz);
            }
        }
    }
    
    /* (non-Javadoc)
     * @see com.chineseall.xcms.core.dao.DaoFactory.DaoLoader#getDao(com.chineseall.xcms.core.vo.Req)
     */
    @Override
    public AbstractDao getDao(Req req) {

        try {
            Class<? extends AbstractDao> resultDaoClass = map.get(req.getSymbolName());
            if(resultDaoClass != null) {
                AbstractDao resultDao = resultDaoClass.newInstance();
                resultDao.setReq(req);
                return resultDao;
            }
            return null;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(String.format("类型【%s】实例创建失败", req.getSymbolName()), e);
        }
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Dao {
        public String symbol();
    }
}
