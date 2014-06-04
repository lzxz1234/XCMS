package com.chineseall.xcms.nb.render;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.bee.tl.core.BeeException;
import org.bee.tl.core.GroupTemplate;
import org.bee.tl.core.Template;

import com.chineseall.xcms.core.render.Render;

public class BeetlRender implements Render {

    private GroupTemplate group = new GroupTemplate();
    {
        group.setTempFolder("D:\\template\\cache");
        group.enableNativeCall();
        group.enableOptimize();
    }
    
    @Override
    public String reader(String tplString, Map<String, Object> ctx) 
            throws IOException, BeeException {
        
        Template template = group.getStringTemplate(tplString);
        if(ctx != null && ctx.size() > 0) {
            Iterator<Entry<String, Object>> it = ctx.entrySet().iterator();
            Entry<String, Object> entry = null;
            while(it.hasNext()) {
                entry = it.next();
                template.set(entry.getKey(), entry.getValue());
            }
        }
        return template.getTextAsString();
    }

}
