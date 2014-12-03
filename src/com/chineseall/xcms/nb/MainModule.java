package com.chineseall.xcms.nb;

import javax.servlet.http.HttpServletRequest;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

import com.chineseall.xcms.core.utils.Ctx;
import com.chineseall.xcms.nb.MainModule.CtxFilter;
import com.chineseall.xcms.nb.module.IndexModule;

@Filters({@By(type=CtxFilter.class)})
@Modules(value=IndexModule.class, scanPackage = true)
@Encoding(input="UTF-8", output="UTF-8")
@IocBy(type = ComboIocProvider.class, args = {
    "*org.nutz.ioc.loader.json.JsonLoader", "config.js", 
    "*org.nutz.ioc.loader.annotation.AnnotationIocLoader", "com.chineseall.xcms"
 })
public class MainModule {

    public static class CtxFilter implements ActionFilter {
        @Override
        public View match(ActionContext actionContext) {
            
            HttpServletRequest request = actionContext.getRequest();
            
            Ctx.set("webroot", request.getContextPath());
            Ctx.set("request", request);
            Ctx.set("response", actionContext.getResponse());
            return null;
        }
    }
    
}
