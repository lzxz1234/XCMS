package com.chineseall.xcms.nb.render;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;

import com.chineseall.xcms.core.render.Render;

public class BeetlRender implements Render {

    private GroupTemplate group;
    
    public void setRootPath(String root) throws IOException {
        
        FileResourceLoader resourceLoader = new FileResourceLoader(root, "utf-8");
        Configuration cfg = Configuration.defaultConfiguration();
        this.group = new GroupTemplate(resourceLoader, cfg);
    }
    
    @Override
    public String reader(String tplString, Map<String, Object> ctx) 
            throws IOException {
        
        Template template = group.getTemplate(tplString);
        if(ctx != null && ctx.size() > 0) {
            Iterator<Entry<String, Object>> it = ctx.entrySet().iterator();
            Entry<String, Object> entry = null;
            while(it.hasNext()) {
                entry = it.next();
                template.binding(entry.getKey(), entry.getValue());
            }
        }
        return template.render();
    }

}
