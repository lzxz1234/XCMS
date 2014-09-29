package com.chineseall.xcms.nb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.ConnCallback;

import com.chineseall.xcms.core.utils.Cfg;
import com.chineseall.xcms.core.utils.StringTemplate;
import com.chineseall.xcms.core.utils.StringTemplate.ReplaceHolder;

/**
 * 工作流状态修改之类的，不用表单点链接直接改数据
 */
public class QuickSetDao extends NutzDao {

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
                
                String sql = Cfg.get("custsql.properties", req.getSymbolName());
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
