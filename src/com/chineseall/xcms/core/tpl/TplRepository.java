package com.chineseall.xcms.core.tpl;

import java.util.List;

import com.chineseall.xcms.core.vo.Req;

public abstract class TplRepository {
    
    public static enum Type {
        Info, Add, AddResult, DelResult, Mod, ModResult, QryResult
    }
    
    public String getObjInfoView(Req req) {
        return this.getView(req, Type.Info);
    }
    public String getAddFormView(Req req) {
        return this.getView(req, Type.Add);
    }
    public String getAddResultView(Req req) {
        return this.getView(req, Type.AddResult);
    }
    public String getDelResultView(Req req) {
        return this.getView(req, Type.DelResult);
    }
    public String getModifyFormView(Req req) {
        return this.getView(req, Type.Mod);
    }
    public String getModifyResultView(Req req) {
        return this.getView(req, Type.ModResult);
    }
    public String getQueryResultView(Req req) {
        return this.getView(req, Type.QryResult);
    }
    
    public abstract String getView(Req req, Type type);
    public abstract String getIndexView(List<String> symbolList);
}
