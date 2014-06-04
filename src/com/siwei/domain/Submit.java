/*
 * @title: Submit.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:52:42
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Submit
 * @description 作者提交作品
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_SUBMIT")
public class Submit extends Domain {

    @Id
    private Long subId;
    @Column
    private Long id;
    @Column
    private Long sUId;
    @Column
    private Date createTime;
    @Column
    private Integer status;
    
    @One(target=User.class, field="sUId")
    private User user;
    @One(target=Resource.class, field="id")
    private Resource resource;
    
    public final User getUser() {
        return user;
    }
    public final void setUser(User user) {
        this.user = user;
    }
    public final Resource getResource() {
        return resource;
    }
    public final void setResource(Resource resource) {
        this.resource = resource;
    }
    /**
     * @return the subId
     */
    public final Long getSubId() {
        return subId;
    }
    /**
     * @param subId the subId to set
     */
    public final void setSubId(Long subId) {
        this.subId = subId;
    }
    /**
     * @return 资源ID
     */
    public final Long getId() {
        return id;
    }
    /**
     * @param id 资源ID
     */
    public final void setId(Long id) {
        this.id = id;
    }
    /**
     * @return 用户表_ID
     */
    public final Long getsUId() {
        return sUId;
    }
    /**
     * @param sUId 用户表_ID
     */
    public final void setsUId(Long sUId) {
        this.sUId = sUId;
    }
    /**
     * @return 提交时间
     */
    public final Date getCreateTime() {
        return createTime;
    }
    /**
     * @param createTime 提交时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * @return 状态
     */
    public final Integer getStatus() {
        return status;
    }
    /**
     * @param status 状态
     */
    public final void setStatus(Integer status) {
        this.status = status;
    }
    
}
