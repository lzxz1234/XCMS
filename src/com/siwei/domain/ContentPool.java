/*
 * @title: ContentPool.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:25:08
 * @version V1.0
 */
package com.siwei.domain;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class ContentPool
 * @description 内容库
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_CONTENT_POOL")
public class ContentPool {

    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer status;
    
    @ManyMany(target=Resource.class, relation="S_C_R", from="S_C_ID", to="ID")
    private List<Resource> resourceList;
    
    public final List<Resource> getResourceList() {
        return resourceList;
    }
    public final void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
    /**
     * @return the id
     */
    public final Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public final void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }
    /**
     * @return the status
     * 1 上线 0 下线
     */
    public final Integer getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     * 1 上线 0 下线
     */
    public final void setStatus(Integer status) {
        this.status = status;
    }
    
}
