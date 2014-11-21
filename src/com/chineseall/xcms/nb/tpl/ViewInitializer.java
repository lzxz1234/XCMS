package com.chineseall.xcms.nb.tpl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import com.chineseall.xcms.core.tpl.TplInitializerAdapter;
import com.chineseall.xcms.core.utils.Ctx;
import com.chineseall.xcms.core.utils.Ctx.Trs;
import com.chineseall.xcms.core.vo.Req;

public class ViewInitializer extends TplInitializerAdapter {

    private final Logger log = Logger.getLogger(ViewInitializer.class);
    
    private GroupTemplate group;
    
    public ViewInitializer() throws IOException {
        
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        group = new GroupTemplate(resourceLoader, cfg);
    }

    @Override
    public String createIndexView(List<String> symbolList) {
        
        try {
            final Template template = group.getTemplate("/com/chineseall/xcms/nb/tpl/index.html");
            template.binding("symbolList", symbolList);
            Ctx.translate(new Trs2Tpl(template));
            return template.render();
        } catch (Exception e) {
            log.error("[系统错误]", e);
            return "";
        }
    }
    
    @Override
    public String createInfoView(Req req) {
        
        try {
            final Template template = group.getTemplate("/com/chineseall/xcms/nb/tpl/info.html");
            template.binding("fieldList", req.getDetailFields());
            Ctx.translate(new Trs2Tpl(template));
            return template.render();
        } catch (Exception e) {
            log.error("[系统错误]", e);
            return "";
        }
    }
    
    @Override
    public String createAddFormView(Req req) {
        
        try {
            Template template = group.getTemplate("/com/chineseall/xcms/nb/tpl/create.html");
            template.binding("fieldList", req.getCreateFields());
            Ctx.translate(new Trs2Tpl(template));
            return template.render();
        } catch (Exception e) {
            log.error("[系统错误]", e);
            return "";
        }
    }

    @Override
    public String createModifyFormView(Req req) {
        
        try {
            Template template = group.getTemplate("/com/chineseall/xcms/nb/tpl/modify.html");
            template.binding("fieldList", req.getUpdateFields());
            Ctx.translate(new Trs2Tpl(template));
            return template.render();
        } catch (Exception e) {
            log.error("[系统错误]", e);
            return "";
        }
    }

    @Override
    public String createQueryResultView(Req req) {
        
        try {
            Template template = group.getTemplate("/com/chineseall/xcms/nb/tpl/query-result.html");
            template.binding("idList", req.getIdFields());
            template.binding("fieldList", req.getSummaryFields());
            Ctx.translate(new Trs2Tpl(template));
            return template.render();
        } catch (Exception e) {
            log.error("[渲染失败]", e);
            return "";
        }
    }

    @Override
    public String createResultView(Req req) {

        return "操作成功 ！！！";
    }

    private static class Trs2Tpl implements Trs {
        private final Template template;
        public Trs2Tpl(Template tpl) {
            this.template = tpl;
        }
        @Override
        public void trs(String key, Object value) {
            template.binding(key, value);
        }
    }

}
