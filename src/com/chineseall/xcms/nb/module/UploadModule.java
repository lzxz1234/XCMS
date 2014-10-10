package com.chineseall.xcms.nb.module;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import com.chineseall.xcms.core.utils.Ctx;

@IocBean
public class UploadModule {

    @At("/upload/")
    @POST
    @Ok("raw:html")
    @AdaptBy(type=UploadAdaptor.class, args={"ioc:myUpload"})
    public String upload(@Param("..") Map<String, Object> map) throws Exception {
        
        StringBuilder sb = new StringBuilder("{");
        if(map != null && map.size() > 0) {
            HttpServletRequest request = Ctx.get(HttpServletRequest.class, "request");
            HttpSession session = request.getSession();
            
            Iterator<Entry<String, Object>> it = map.entrySet().iterator();
            String randomKey;
            Entry<String, Object> entry;
            while(it.hasNext()){
                entry = it.next();
                if(entry.getValue() instanceof TempFile) {
                    randomKey = randomKey();
                    session.setAttribute(randomKey, entry.getValue());
                    sb.append("\"").append(entry.getKey()).append("\": \"");
                    sb.append(randomKey).append("\",");
                }
            }
            if(sb.length() > 1)
                sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("}");
        return sb.toString();
    }
    
    private String randomKey() {
        
        return UUID.randomUUID().toString();
    }
}
