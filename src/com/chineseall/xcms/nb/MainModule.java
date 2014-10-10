package com.chineseall.xcms.nb;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;

import com.chineseall.xcms.core.utils.Ctx;
import com.chineseall.xcms.nb.MainModule.CtxFilter;

@Filters({@By(type=CtxFilter.class)})
@Modules(scanPackage = true)
@Encoding(input="UTF-8", output="UTF-8")
public class MainModule {

    private NutzProcessor processor;
    
    public MainModule() {
        
        Ioc ioc = new NutIoc(new JsonLoader("config.js"));
        this.processor = ioc.get(NutzProcessor.class, "nutzProcessor");
    }
    
    @At("/")
    @GET
    @Ok("raw:html")
    public String index() throws Exception {
        
        return processor.renderIndex();
    }
    
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
    
    public static class CtxFilter implements ActionFilter {
        @Override
        public View match(ActionContext actionContext) {
            
            HttpServletRequest request = actionContext.getRequest();
            StringBuilder sb = new StringBuilder();
            sb.append(request.getScheme());
            sb.append("://");
            sb.append(request.getServerName());
            sb.append(":");
            sb.append(request.getServerPort());
            sb.append(request.getContextPath());
            
            Ctx.set("webroot", sb.toString());;
            Ctx.set("request", request);
            Ctx.set("response", actionContext.getResponse());
            return null;
        }
    }
    
}
