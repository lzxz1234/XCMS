/**
 * XCMS
 * @title DefaultDaoLoader.java
 * @package com.chineseall.xcms.core.dao
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月11日-下午2:50:44
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chineseall.xcms.core.dao;

import com.chineseall.xcms.core.dao.DaoFactory.DaoLoader;
import com.chineseall.xcms.core.vo.Req;

/**
 * @class DefaultDaoLoader
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class DefaultDaoLoader implements DaoLoader {

    private String defaultDaoClass;
    
    /* (non-Javadoc)
     * @see com.chineseall.xcms.core.dao.DaoFactory.DaoLoader#getDao(com.chineseall.xcms.core.vo.Req)
     */
    @Override
    public AbstractDao getDao(Req req) {
        
        try {
            AbstractDao result = (AbstractDao) Class.forName(defaultDaoClass).newInstance();
            result.setReq(req);
            return result;
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e) {
            throw new RuntimeException(String.format("类【%s】实例创建失败", defaultDaoClass), e);
        }
    }

    
    
}
