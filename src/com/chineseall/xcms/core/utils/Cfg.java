package com.chineseall.xcms.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class Cfg {

    private static final Logger log = Logger.getLogger(Cfg.class);

    private static ConcurrentHashMap<String, Cfg> map = new ConcurrentHashMap<String, Cfg>();

    public static Cfg getCfg(String location) {

        Cfg result = map.get(location);
        if (result == null) {
            result = new Cfg(location);
            map.put(location, result);
        }
        return result;
    }
    
    public static String get(String location, String key) {
        
        return Cfg.getCfg(location).getProperty(key);
    }

    private File file;
    private long lastModified;
    private Properties prop = new Properties();

    private Cfg(String location) {

        URL url = Cfg.class.getClassLoader().getResource(location);
        if (url == null)
            throw new RuntimeException(location + "未找到！！");

        try {
            file = new File(URLDecoder.decode(url.getPath(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            //Ignore
        }
        reload();
        Exec.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                reload();
            }
        }, 5 * 60, 5 * 60, TimeUnit.SECONDS);

    }

    public String getProperty(String key) {

        return prop.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {

        return prop.getProperty(key, defaultValue);
    }

    private void reload() {

        if (file.lastModified() != lastModified) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                prop.load(new InputStreamReader(fis, "UTF-8"));
            } catch (Exception e) {
                log.error("加载配置文件异常", e);
            } finally {
                IOUtils.closeQuietly(fis);
            }
        }
    }

}
