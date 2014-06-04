/*
 * @title: Log.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:26:55
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Log
 * @description 管理日志记录
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_LOG")
public class Log extends Domain {

    @Id
    private Long lId;
    @Column
    private Integer id;
    @Column
    private String action;
    @Column
    private Integer oId;
    @Column
    private Integer type;
    @Column
    private Date lTime;
    
    @One(target=Manager.class, field="id")
    private Manager manager;
    
    public final Manager getManager() {
        return manager;
    }
    public final void setManager(Manager manager) {
        this.manager = manager;
    }
    /**
     * @return 日志ID
     */
    public final Long getlId() {
        return lId;
    }
    /**
     * @param lId 日志ID
     */
    public final void setlId(Long lId) {
        this.lId = lId;
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
     * @return 动作描述
     */
    public final String getAction() {
        return action;
    }
    /**
     * @param action 动作描述
     */
    public final void setAction(String action) {
        this.action = action;
    }
    /**
     * @return 操作对象ID
     */
    public final Integer getoId() {
        return oId;
    }
    /**
     * @param oId 操作对象ID
     */
    public final void setoId(Integer oId) {
        this.oId = oId;
    }
    /**
     * @return 操作对象类型
     */
    public final Integer getType() {
        return type;
    }
    /**
     * @param type 操作对象类型
     */
    public final void setType(Integer type) {
        this.type = type;
    }
    /**
     * @return 时间
     */
    public final Date getlTime() {
        return lTime;
    }
    /**
     * @param lTime 时间
     */
    public final void setlTime(Date lTime) {
        this.lTime = lTime;
    }
    
}
