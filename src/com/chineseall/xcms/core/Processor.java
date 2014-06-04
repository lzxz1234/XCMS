package com.chineseall.xcms.core;

import java.util.Map;


public interface Processor {
    
    public String renderIndex() throws Exception;
    
    public String renderObjInfo(String domainSymbol, long id) 
            throws Exception;
    
    /**
     * @return 绘制新添记录表单，并返回HTML格式内容
     */
    public String renderAddForm(String domainSymbol) throws Exception;
    
    /**
     * @return 执行数据库新添操作，并返回HTML格式内容
     */
    public String doAddAction(String domainSymbol, Map<String, Object> params) 
            throws Exception;
    
    /**
     * @return 执行数据库删除操作，并返回HTML格式内容
     */
    public String doDelAction(String domainSymbol, long id) throws Exception;
    
    /**
     * @return 绘制记录修改表单，并返回HTML格式内容
     */
    public String renderModifyForm(String domainSymbol, long id) throws Exception;
    
    /**
     * @return 执行修改操作，并返回HTML格式内容
     */
    public String doModifyAction(String domainSymbol, long id, Map<String, Object> params) 
            throws Exception;
    
    /**
     * @return 执行查询操作，并返回HTML格式内容
     */
    public String doQueryAction(String domainSymbol, Map<String, String> params) 
            throws Exception;
    
}
