package com.chineseall.xcms.core.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class IOUtils {

    public static final void closeQuietly(Closeable x) {
        
        if(x != null)
            try {
                x.close();
            } catch (Exception e){
            }
    }
    
    public static void toFile(File target, String content, String charset) throws IOException {
        
        FileOutputStream fos = new FileOutputStream(target);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        try {
            bos.write(content.getBytes(Charset.forName(charset)));
        } finally {
            closeQuietly(bos);
            closeQuietly(fos);
        }
    }
    public static String toString(File target, String charset) throws IOException {
        
        return new String(readFully(target), charset);
    }
    
    public static void ensureDirExists(File target) {
        
        if(target == null)
            throw new NullPointerException();
        if(!target.exists()) target.mkdirs();
    }
    public static byte[] readFully(final File target) throws IOException {
        
        FileInputStream fis = null;
        try {
            if(target == null || !target.exists()) return new byte[0];
            fis = new FileInputStream(target);
            return readFully(fis);
        } finally {
            closeQuietly(fis);
        }
    }
    
    public static byte[] readFully(final InputStream is) throws IOException {
        
        ByteArrayOutputStream output = new ByteArrayOutputStream(4096);
        byte[] buffer = new byte[4096];
        int n = 0;
        while ((n = is.read(buffer)) != -1) 
            output.write(buffer, 0, n);
        return output.toByteArray();
    }

}
