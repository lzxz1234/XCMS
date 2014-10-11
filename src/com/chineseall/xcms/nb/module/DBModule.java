package com.chineseall.xcms.nb.module;

import java.util.Map;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;

import com.chineseall.xcms.nb.NutzProcessor;

@IocBean
public class DBModule {

    @Inject("refer:nutzProcessor")
    private NutzProcessor processor;
    
    @At("/get/?/?")
    @GET
    @Ok("raw:html")
    public String get(String classSymbol, long id) throws Exception {
        
        return processor.renderObjInfo(classSymbol, id);
    }
    
    @At("/add-form/?")
    @GET
    @Ok("raw:html")
    public String getAdd(String classSymbol) throws Exception {
        
        return processor.renderAddForm(classSymbol);
    }
    
    @At("/add/?")
    @POST
    @Ok("raw:html")
    public String doAdd(String classSymbol, @Param("..") Map<String, Object> map) 
            throws Exception {
        
        return processor.doAddAction(classSymbol, map);
    }
    
    @At("/mod-form/?/?")
    @GET
    @Ok("raw:html")
    public String getMod(String classSymbol, long id) throws Exception {
        
        return processor.renderModifyForm(classSymbol, id);
    }
    
    @At("/mod/?/?")
    @Ok("raw:html")
    public String doMod(String classSymbol, long id, @Param("..") Map<String, Object> map) 
            throws Exception {
        
        return processor.doModifyAction(classSymbol, id, map);
    }
    
    @At("/del/?/?")
    @Ok("raw:html")
    public String doDel(String classSymbol, long id) throws Exception {
        
        return processor.doDelAction(classSymbol, id);
    }
    
    @At("/qry/?")
    @Ok("raw:html")
    public String doQry(String classSymbol, @Param("..") Map<String, String> map) 
            throws Exception {
        
        String pageSize = map.get("pageSize");
        String pageNo = map.get("pageNo");
        if(pageSize == null || pageSize.length() == 0) map.put("pageSize", "10");
        if(pageNo == null || pageNo.length() == 0) map.put("pageNo", "1");
        return processor.doQueryAction(classSymbol, map);
    }
    
}
