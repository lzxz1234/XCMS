/*
 * @title: Manager.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:33:46
 * @version V1.0
 */
package com.siwei.domain;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Manager
 * @description 管理员
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_MANAGER")
public class Manager extends Domain {

    @Id
    private Integer id;
    @Name
    private String loginName;
    @Column
    private String passwd;
    @Column
    private Integer level;
    @Column
    private Integer status;
    @Column
    private String email;
    @Column
    private String mobile;
    @Column
    private String name;
    
    @Many(target=Log.class, field="id")
    private List<Log> logList;
    @Many(target=CheckRecord.class, field="id")
    private List<CheckRecord> checkRecordList;
    
    public final List<CheckRecord> getCheckRecordList() {
        return checkRecordList;
    }
    public final void setCheckRecordList(List<CheckRecord> checkRecordList) {
        this.checkRecordList = checkRecordList;
    }
    public final List<Log> getLogList() {
        return logList;
    }
    public final void setLogList(List<Log> logList) {
        this.logList = logList;
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
     * @return 登录名
     */
    public final String getLoginName() {
        return loginName;
    }
    /**
     * @param loginName 登录名
     */
    public final void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    /**
     * @return 密码
     */
    public final String getPasswd() {
        return passwd;
    }
    /**
     * @param passwd 密码
     */
    public final void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    /**
     * @return 级别<br>
     * 0: 超级管理员
1:管理员
2:编辑用户
3:审核用户
     */
    public final Integer getLevel() {
        return level;
    }
    /**
     * @param level 级别<br>
     * 0: 超级管理员
1:管理员
2:编辑用户
3:审核用户
     */
    public final void setLevel(Integer level) {
        this.level = level;
    }
    /**
     * @return 状态<br>
     * 1:可用,0:暂停
     */
    public final Integer getStatus() {
        return status;
    }
    /**
     * @param status 状态<br>
     * 1:可用,0:暂停
     */
    public final void setStatus(Integer status) {
        this.status = status;
    }
    /**
     * @return 邮箱
     */
    public final String getEmail() {
        return email;
    }
    /**
     * @param email 邮箱
     */
    public final void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return 手机号
     */
    public final String getMobile() {
        return mobile;
    }
    /**
     * @param mobile 手机号
     */
    public final void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
     * @return 姓名
     */
    public final String getName() {
        return name;
    }
    /**
     * @param name 姓名
     */
    public final void setName(String name) {
        this.name = name;
    }
    
}
