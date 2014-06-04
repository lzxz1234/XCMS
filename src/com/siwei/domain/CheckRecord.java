/*
 * @title: CheckRecord.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午12:12:08
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class CheckRecord
 * @description 审核记录表
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_CHECK_RECORD")
public class CheckRecord {

    @Id
    private Long checkId;
    @Column
    private Integer id;
    @Column
    private Long resId;
    @Column
    private Date createTime;
    @Column
    private String reason;
    @Column
    private Integer result;
    
    @One(target=Manager.class, field="id")
    private Manager manager;
    @One(target=Resource.class, field="resId")
    private Resource resource;
    
    public final Manager getManager() {
        return manager;
    }
    public final void setManager(Manager manager) {
        this.manager = manager;
    }
    public final Resource getResource() {
        return resource;
    }
    public final void setResource(Resource resource) {
        this.resource = resource;
    }
    /**
     * @return 审核ID
     */
    public final Long getCheckId() {
        return checkId;
    }
    /**
     * @param checkId 审核ID
     */
    public final void setCheckId(Long checkId) {
        this.checkId = checkId;
    }
    /**
     * @return 管理员ID
     */
    public final Integer getId() {
        return id;
    }
    /**
     * @param id 管理员ID
     */
    public final void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return 资源表_资源ID
     */
    public final Long getResId() {
        return resId;
    }
    /**
     * @param resId 资源表_资源ID
     */
    public final void setResId(Long resId) {
        this.resId = resId;
    }
    /**
     * @return 审核时间
     */
    public final Date getCreateTime() {
        return createTime;
    }
    /**
     * @param createTime 审核时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * @return 理由
     */
    public final String getReason() {
        return reason;
    }
    /**
     * @param reason 理由
     */
    public final void setReason(String reason) {
        this.reason = reason;
    }
    /**
     * @return 审核结果
     */
    public final Integer getResult() {
        return result;
    }
    /**
     * @param result 审核结果
     */
    public final void setResult(Integer result) {
        this.result = result;
    }
    
}
