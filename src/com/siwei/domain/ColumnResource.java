/*
 * @title: ColumnResource.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-7-8 下午5:27:56
 * @version V1.0
 */
package com.siwei.domain;

import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class ColumnResource
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_COLUMN_RESOURCE")
@PK({"cId", "id"})
public class ColumnResource extends Domain {

    private Long cId;
    private Long id;
    
    public ColumnResource() {}
    
    public ColumnResource(Long cId, Long id) {
        
        this.cId = cId;
        this.id = id;
    }

    /**
     * @return the cId
     */
    public final Long getcId() {
        return cId;
    }

    /**
     * @param cId the cId to set
     */
    public final void setcId(Long cId) {
        this.cId = cId;
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
    
}
