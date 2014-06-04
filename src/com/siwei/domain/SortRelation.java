/*
 * @title: SortRelation.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-7-4 上午9:38:38
 * @version V1.0
 */
package com.siwei.domain;

import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class SortRelation
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_SORT_RELATION")
@PK({"id", "sSId"})
public class SortRelation extends Domain {

    private Long id;
    private Long sSId;
    
    public SortRelation() {}
    
    public SortRelation(Long from, Long to) {
        this.id = from;
        this.sSId = to;
    }
    /**
     * @return RESOURCE ID
     */
    public final Long getId() {
        return id;
    }
    /**
     * @param id RESOURCE ID
     */
    public final void setId(Long id) {
        this.id = id;
    }
    /**
     * @return SORT ID
     */
    public final Long getsSId() {
        return sSId;
    }
    /**
     * @param sSId SORT ID
     */
    public final void setsSId(Long sSId) {
        this.sSId = sSId;
    }
    
}
