/*
 * @title: AuthorApplication.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 上午11:28:58
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class AuthorApplication
 * @description 作者申请记录
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_AUTHOR_APPLICATION")
public class AuthorApplication extends Domain {
    
    @Id
    private Long applyId;
    @Column
    private Long userId;
    @Column
    private Integer managerId;
    @Column
    private String domicile;
    @Column
    private Date createTime;
    @Column
    private String result;
    
    @One(target=User.class, field="userId")
    private User user;
    @One(target=Manager.class, field="managerId")
    private Manager manager;
    
    
    public final User getUser() {
        return user;
    }
    public final void setUser(User user) {
        this.user = user;
    }
    public final Manager getManager() {
        return manager;
    }
    public final void setManager(Manager manager) {
        this.manager = manager;
    }
    /**
     * @return 申请记录ID
     */
    public final Long getApplyId() {
        return applyId;
    }
    /**
     * @param applyId 申请记录ID
     */
    public final void setApplyId(Long applyId) {
        this.applyId = applyId;
    }
    /**
     * @return 用户ID
     */
    public final Long getUserId() {
        return userId;
    }
    /**
     * @param userId 用户ID
     */
    public final void setUserId(Long userId) {
        this.userId = userId;
    }
    /**
     * @return 管理员ID
     */
    public final Integer getManagerId() {
        return managerId;
    }
    /**
     * @param managerId 管理员ID
     */
    public final void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
    /**
     * @return 居住地
     */
    public final String getDomicile() {
        return domicile;
    }
    /**
     * @param domicile 居住地
     */
    public final void setDomicile(String domicile) {
        this.domicile = domicile;
    }
    /**
     * @return 申请时间
     */
    public final Date getCreateTime() {
        return createTime;
    }
    /**
     * @param createTime 申请时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * @return 申请结果
     */
    public final String getResult() {
        return result;
    }
    /**
     * @param result 申请结果
     */
    public final void setResult(String result) {
        this.result = result;
    }
    
}
