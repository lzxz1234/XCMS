package com.chineseall.xcms.core.render;

import java.util.Map;

public interface Render {
    
    public String reader(String tpl, Map<String, Object> ctx) throws Exception;
    
}
