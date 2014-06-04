/*
 * @title: ContentPoolResource.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-7-3 下午5:49:12
 * @version V1.0
 */
package com.siwei.domain;

import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class ContentPoolResource
 * @description 资源池和资源的关联关系
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_C_R")
@PK({"id", "sCId"})
public class ContentPoolResource extends Domain {

    private Long id;
    private Integer sCId;
    
    public ContentPoolResource() {}
    
    public ContentPoolResource(Long from, Integer to) {
        this.id =from;
        this.sCId = to;
    }
    /**
     * @return Resource Id
     */
    public final Long getId() {
        return id;
    }
    /**
     * @param id Resource Id
     */
    public final void setId(Long id) {
        this.id = id;
    }
    /**
     * @return ContentPool Id
     */
    public final Integer getsCId() {
        return sCId;
    }
    /**
     * @param sCId ContentPool Id
     */
    public final void setsCId(Integer sCId) {
        this.sCId = sCId;
    }
    
}
