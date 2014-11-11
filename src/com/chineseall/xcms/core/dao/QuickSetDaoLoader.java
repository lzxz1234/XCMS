/**
 * XCMS
 * @title QuickSetDaoLoader.java
 * @package com.chineseall.xcms.core.dao
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月11日-下午3:23:23
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chineseall.xcms.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.ConnCallback;

import com.chineseall.xcms.core.dao.DaoFactory.DaoLoader;
import com.chineseall.xcms.core.utils.Cfg;
import com.chineseall.xcms.core.utils.StringTemplate;
import com.chineseall.xcms.core.utils.StringTemplate.ReplaceHolder;
import com.chineseall.xcms.core.vo.Req;
import com.chineseall.xcms.nb.dao.NutzDao;

/**
 * @class QuickSetDaoLoader
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class QuickSetDaoLoader implements DaoLoader {

    private Cfg cfg = Cfg.getCfg("custsql.properties");
    
    /* (non-Javadoc)
     * @see com.chineseall.xcms.core.dao.DaoFactory.DaoLoader#getDao(com.chineseall.xcms.core.vo.Req)
     */
    @Override
    public AbstractDao getDao(Req req) {
        
        final String sql = cfg.getProperty(req.getSymbolName());
        if(sql != null)
            return new NutzDao() {
                @Override
                public Object get(long id) {
                    return new HashMap<>();
                }

                @Override
                public void add(Object target) {
                }

                @Override
                public void del(long id) {
                }

                @Override
                public void mod(final Object target) {
                    dao.run(new ConnCallback() {
                        @Override
                        public void invoke(Connection conn) throws Exception {
                            
                            SqlTemplate template = new SqlTemplate(sql, (Map<?, ?>)target);
                            PreparedStatement prep = conn.prepareStatement(template.sql);
                            for(int i = 0; i < template.sqlParamList.size(); i ++)
                                prep.setObject(i + 1, template.sqlParamList.get(i));
                            prep.addBatch();
                            prep.executeBatch();
                            conn.commit();
                        }
                    });
                }

                @Override
                public List<?> qry(Map<String, String> params) {
                    return new ArrayList<>();
                }

                @Override
                public int cnt(Map<String, String> params) {
                    return 0;
                }
            };
        return null;
    }

    private static class SqlTemplate {
        final StringTemplate template;
        final String sql;
        final List<Object> sqlParamList;
        public SqlTemplate(String sql, final Map<?, ?> params) {
            
            this.template = StringTemplate.compile(sql);
            this.sqlParamList = new ArrayList<Object>();
            this.sql = template.replace(new ReplaceHolder() {
                @Override
                public String get(String key) {
                    sqlParamList.add(params.get(key));
                    return "?";
                }
            });
        }
        
    }
}
