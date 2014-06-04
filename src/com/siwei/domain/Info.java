/*
 * @title: Info.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 上午11:23:21
 * @version V1.0
 */
package com.siwei.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Info
 * @description 资讯表
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_INFO")
public class Info extends Domain {

    @Id(auto=false)
    private Long id;
    @Column
    private String source;
    @Column
    private String content;
    
    @One(target=Resource.class, field="id")
    private Resource resource;
    
    public final Resource getResource() {
        return resource;
    }
    public final void setResource(Resource resource) {
        this.resource = resource;
    }
    /**
     * @return the id
     */
    public final Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public final void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the source
     */
    public final String getSource() {
        return source;
    }
    /**
     * @param source the source to set
     */
    public final void setSource(String source) {
        this.source = source;
    }
    /**
     * @return the content
     */
    public final String getContent() {
        return content;
    }
    /**
     * @param content the content to set
     */
    public final void setContent(String content) {
        this.content = content;
    }
    
}
