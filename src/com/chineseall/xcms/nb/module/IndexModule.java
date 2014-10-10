package com.chineseall.xcms.nb.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;

import com.chineseall.xcms.nb.NutzProcessor;

@IocBean
public class IndexModule {

    @Inject("refer:nutzProcessor")
    private NutzProcessor processor;
    
    @At("/")
    @GET
    @Ok("raw:html")
    public String index() throws Exception {
        
        return processor.renderIndex();
    }
    
}
