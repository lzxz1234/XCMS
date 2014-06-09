package com.chineseall.xcms.core.tpl;

import java.util.List;

import com.chineseall.xcms.core.vo.Req;

/**
 * 模板生成器，当对应模板不存在时由该类生成
 */
public abstract class TplInitializerAdapter {
    
    public String createAddResultView(Req req) {
        return createResultView(req);
    }
    public String createDelResultView(Req req) {
        return createResultView(req);
    }
    public String createModifyResultView(Req req) {
        return createResultView(req);
    }
    
    public abstract String createQueryResultView(Req req);
    
    public abstract String createInfoView(Req req);
    public abstract String createAddFormView(Req req);
    public abstract String createModifyFormView(Req req);
    public abstract String createResultView(Req req);
    
    public abstract String createIndexView(List<String> symbolList);
}
