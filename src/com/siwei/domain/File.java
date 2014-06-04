/*
 * @title: File.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 上午11:06:18
 * @version V1.0
 */
package com.siwei.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class File
 * @description 文件资源表<br>
 * 包括图片、音频、视频等单个文件资源
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_FILE")
public class File extends Domain {

    @Id(auto=false)
    private Long id;
    @Column
    private String filename;
    @Column
    private String extName;
    @Column
    private String mime;
    
    @One(target=Resource.class, field="id")
    private Resource resource;
    
    public final Resource getResource() {
        return resource;
    }
    public final void setResource(Resource resource) {
        this.resource = resource;
    }
    
    /**
     * @return 文件ID
     */
    public final Long getId() {
        return id;
    }
    /**
     * @param id 文件ID
     */
    public final void setId(Long id) {
        this.id = id;
    }
    /**
     * @return 文件名
     */
    public final String getFilename() {
        return filename;
    }
    /**
     * @param filename 文件名
     */
    public final void setFilename(String filename) {
        this.filename = filename;
    }
    /**
     * @return 文件扩展名
     */
    public final String getExtName() {
        return extName;
    }
    /**
     * @param extName 文件扩展名
     */
    public final void setExtName(String extName) {
        this.extName = extName;
    }
    /**
     * @return MIME
     */
    public final String getMime() {
        return mime;
    }
    /**
     * @param mime MIME
     */
    public final void setMime(String mime) {
        this.mime = mime;
    }
    
}
