package com.chineseall.xcms.core.tpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.chineseall.xcms.core.utils.IOUtils;
import com.chineseall.xcms.core.vo.Req;

public class FileSystemTplRepository extends TplRepository {

    private final Logger log = Logger.getLogger(FileSystemTplRepository.class);
    
    private String rootPath;
    private TplInitializerAdapter initializer;
    
    public void init() {
        
        log.info(String.format("模板池路径：%s", rootPath));
        rootPath = rootPath.matches("[/\\\\]$") ? rootPath : rootPath + File.separator;
        IOUtils.ensureDirExists(new File(this.rootPath));
    }
    
    public String getIndexView(List<String> symbolList) {
        
        try {
            String resourceLocation = rootPath + "index.html";
            String result = getView(resourceLocation);
            if(isEmpty(result)) {
                result = initializer.createIndexView(symbolList);
                IOUtils.toFile(new File(resourceLocation), result, "UTF-8");
            }
            return result;
        } catch (Exception e) {
            log.error("[模板操作失败]", e);
            return "";
        }
    }
    
    public String getView(Req req, Type type) {
        
        try {
            String entityName = req.getEntityClassName();
            String resourceLocation = rootPath + entityName + File.separator + type + ".html";
            String result = getView(resourceLocation);
            if(isEmpty(result)) {
                switch(type) {
                case Info:
                    result = initializer.createInfoView(req);
                    break;
                case Add:
                    result = initializer.createAddFormView(req);
                    break;
                case AddResult:
                    result = initializer.createAddResultView(req);
                    break;
                case DelResult:
                    result = initializer.createDelResultView(req);
                    break;
                case Mod:
                    result = initializer.createModifyFormView(req);
                    break;
                case ModResult:
                    result = initializer.createModifyResultView(req);
                    break;
                case QryResult:
                    result = initializer.createQueryResultView(req);
                }
                IOUtils.toFile(new File(resourceLocation), result, "UTF-8");
            }
            return result;
        } catch (Exception e) {
            log.error("[模板操作失败]", e);
            return "";
        }
    }

    private boolean isEmpty(String str) {
        
        return str == null || str.length() == 0;
    }
    private String getView(String resourceLocation) throws IOException {
        
        return IOUtils.toString(new File(resourceLocation), "UTF-8");
    }
    
}
