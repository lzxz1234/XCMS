/*
 * @title: Mail.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:29:57
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Mail
 * @description 站内信表
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_MAIL")
public class Mail extends Domain {

    @Id
    private Long id;
    @Column
    private Long userId;
    @Column
    private String subject;
    @Column
    private String content;
    @Column
    private Integer senderId;
    @Column
    private String sender;
    @Column
    private Date sendTime;
    @Column
    private boolean readed;
    @Column
    private boolean replied;
    
    @One(target=User.class, field="userId")
    private User user;
    
    public final User getUser() {
        return user;
    }
    public final void setUser(User user) {
        this.user = user;
    }
    /**
     * @return 邮件ID
     */
    public final Long getId() {
        return id;
    }
    /**
     * @param id 邮件ID
     */
    public final void setId(Long id) {
        this.id = id;
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
     * @return 主题
     */
    public final String getSubject() {
        return subject;
    }
    /**
     * @param subject 主题
     */
    public final void setSubject(String subject) {
        this.subject = subject;
    }
    /**
     * @return 内容
     */
    public final String getContent() {
        return content;
    }
    /**
     * @param content 内容
     */
    public final void setContent(String content) {
        this.content = content;
    }
    /**
     * @return 发件人ID
     */
    public final Integer getSenderId() {
        return senderId;
    }
    /**
     * @param senderId 发件人ID
     */
    public final void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }
    /**
     * @return 发件人
     */
    public final String getSender() {
        return sender;
    }
    /**
     * @param sender 发件人
     */
    public final void setSender(String sender) {
        this.sender = sender;
    }
    /**
     * @return 发件时间
     */
    public final Date getSendTime() {
        return sendTime;
    }
    /**
     * @param sendTime 发件时间
     */
    public final void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
    /**
     * @return 已读
     */
    public final boolean isReaded() {
        return readed;
    }
    /**
     * @param readed 已读
     */
    public final void setReaded(boolean readed) {
        this.readed = readed;
    }
    /**
     * @return 回复
     */
    public final boolean isReplied() {
        return replied;
    }
    /**
     * @param replied 回复
     */
    public final void setReplied(boolean replied) {
        this.replied = replied;
    }
    
}
