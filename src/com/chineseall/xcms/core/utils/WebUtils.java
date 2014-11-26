package com.chineseall.xcms.core.utils;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import com.chineseall.xcms.nb.MainModule;

public class WebUtils {

    public static String getWebInfPath() {
        
        return getWebInfPath("");
    }
    
    public static String getWebInfPath(String suffix){
        
        URL url = MainModule.class.getProtectionDomain().getCodeSource().getLocation();
        String path = url.toString();
        int index = path.indexOf("WEB-INF");
        
        if(index == -1){
            index = path.indexOf("classes");
        }
        
        if(index == -1){
            index = path.indexOf("bin");
        }
        
        path = path.substring(0, index);
        
        if(path.startsWith("zip")){//当class文件在war中时，此时返回zip:D:/...这样的路径
            path = path.substring(4);
        }else if(path.startsWith("file")){//当class文件在class文件中时，此时返回file:/D:/...这样的路径
            path = path.substring(Lang.isWin() ? 6 : 5);
        }else if(path.startsWith("jar")){//当class文件在jar文件里面时，此时返回jar:file:/D:/...这样的路径
            path = path.substring(Lang.isWin() ? 10 : 9); 
        }
        try {
            path =  URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        return path + suffix;
    }

}
