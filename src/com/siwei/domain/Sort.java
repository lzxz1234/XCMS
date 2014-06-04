/*
 * @title: Sort.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:49:24
 * @version V1.0
 */
package com.siwei.domain;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Sort
 * @description 内容分类
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_SORT")
public class Sort extends Domain {

    @Id
    private Long id;
    @Column
    private String name;
    
    @ManyMany(target=Resource.class, relation="S_SORT_RELATION", from="S_S_ID", to="ID")
    private List<Resource> resourceList;
    
    public final List<Resource> getResourceList() {
        return resourceList;
    }
    public final void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
    /**
     * @return ID
     */
    public final Long getId() {
        return id;
    }
    /**
     * @param id ID
     */
    public final void setId(Long id) {
        this.id = id;
    }
    /**
     * @return NAME
     */
    public final String getName() {
        return name;
    }
    /**
     * @param name NAME
     */
    public final void setName(String name) {
        this.name = name;
    }
    
}
