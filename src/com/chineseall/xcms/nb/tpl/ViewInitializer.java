package com.chineseall.xcms.nb.tpl;

import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.bee.tl.core.GroupTemplate;
import org.bee.tl.core.Template;

import com.chineseall.xcms.core.tpl.TplInitializerAdapter;
import com.chineseall.xcms.core.utils.Ctx;
import com.chineseall.xcms.core.utils.IOUtils;
import com.chineseall.xcms.core.utils.Ctx.Trs;
import com.chineseall.xcms.core.vo.Req;

public class ViewInitializer extends TplInitializerAdapter {

    private final Logger log = Logger.getLogger(ViewInitializer.class);
    
    private GroupTemplate group = new GroupTemplate();
    {
        group.enableNativeCall();
    }

    @Override
    public String createIndexView(List<String> symbolList) {
        
        try {
            String tplString = loadFromResource("index.html");
            final Template template = group.getStringTemplate(tplString);
            template.set("symbolList", symbolList);
            Ctx.translate(new Trs2Tpl(template));
            return template.getTextAsString();
        } catch (Exception e) {
            log.error("[系统错误]", e);
            return "";
        }
    }
    
    @Override
    public String createInfoView(Req req) {
        
        try {
            String tplString = loadFromResource("info.html");
            final Template template = group.getStringTemplate(tplString);
            template.set("fieldList", req.getDetailFields());
            Ctx.translate(new Trs2Tpl(template));
            return template.getTextAsString();
        } catch (Exception e) {
            log.error("[系统错误]", e);
            return "";
        }
    }
    
    @Override
    public String createAddFormView(Req req) {
        
        try {
            String tplString = loadFromResource("create.html");
            Template template = group.getStringTemplate(tplString);
            template.set("fieldList", req.getCreateFields());
            Ctx.translate(new Trs2Tpl(template));
            return template.getTextAsString();
        } catch (Exception e) {
            log.error("[系统错误]", e);
            return "";
        }
    }

    @Override
    public String createModifyFormView(Req req) {
        
        try {
            String tplString = loadFromResource("modify.html");
            Template template = group.getStringTemplate(tplString);
            template.set("fieldList", req.getUpdateFields());
            Ctx.translate(new Trs2Tpl(template));
            return template.getTextAsString();
        } catch (Exception e) {
            log.error("[系统错误]", e);
            return "";
        }
    }

    @Override
    public String createQueryResultView(Req req) {
        
        try {
            String tplString = loadFromResource("query-result.html");
            Template template = group.getStringTemplate(tplString);
            template.set("idList", req.getIdFields());
            template.set("fieldList", req.getSummaryFields());
            Ctx.translate(new Trs2Tpl(template));
            return template.getTextAsString();
        } catch (Exception e) {
            log.error("[渲染失败]", e);
            return "";
        }
    }

    @Override
    public String createResultView(Req req) {

        return "操作成功 ！！！";
    }

    private String loadFromResource(String location) {
        
        InputStream is = null;
        try {
            is = this.getClass().getResourceAsStream(location);
            return new String(IOUtils.readFully(is), "UTF-8");
        } catch (Exception e) {
            log.error(String.format("[加载资源%s失败]", location), e);
            return "";
        } finally {
            IOUtils.closeQuietly(is);
        }
    }
    
    private static class Trs2Tpl implements Trs {
        private final Template template;
        public Trs2Tpl(Template tpl) {
            this.template = tpl;
        }
        @Override
        public void trs(String key, Object value) {
            template.set(key, value);
        }
    }

}
