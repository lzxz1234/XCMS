/*
 * @title: Comment.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:18:52
 * @version V1.0
 */
package com.siwei.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.json.JsonFormat;
import org.nutz.json.ToJson;

/**
 * @class Comment
 * @description 评论
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@ToJson
@Table("S_COMMENT")
public class Comment extends Domain {

    @Id
    private Long commentId;
    @Column
    private Long id;
    @Column
    private Long resId;
    @Column
    private Long userId;
    @Column
    private String content;
    @Column
    private String nickName;
    @Column
    private Integer isAnonymous;
    @Column
    private Integer rType;
    @Column
    private Date createTime;
    
    @One(target=Resource.class, field="resId")
    private Resource resource;
    @One(target=User.class, field="userId")
    private User user;
    
 
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
     * @return 评论Id
     */
    public final Long getCommentId() {
        return commentId;
    }
    /**
     * @param commentId 评论Id
     */
    public final void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
    /**
     * @return 章节ID
     */
    public final Long getId() {
        return id;
    }
    /**
     * @param id 章节ID
     */
    public final void setId(Long id) {
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
     * @return 评论内容
     */
    public final String getContent() {
        return content;
    }
    /**
     * @param content 评论内容
     */
    public final void setContent(String content) {
        this.content = content;
    }
    /**
     * @return 评论昵称
     */
    public final String getNickName() {
        return nickName;
    }
    /**
     * @param nickName 评论昵称
     */
    public final void setNickName(String nickName) {
        this.nickName = nickName;
    }
    /**
     * @return 是否匿名
     */
    public final Integer getIsAnonymous() {
        return isAnonymous;
    }
    /**
     * @param isAnonymous 是否匿名
     */
    public final void setIsAnonymous(Integer isAnonymous) {
        this.isAnonymous = isAnonymous;
    }
    /**
     * @return 评论对象类型
     */
    public final Integer getrType() {
        return rType;
    }
    /**
     * @param tType 评论对象类型
     */
    public final void setrType(Integer rType) {
        this.rType = rType;
    }
    
    public final Date getCreateTime() {
        return createTime;
    }
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String toJson(JsonFormat format) {
        
        StringBuilder sb = new StringBuilder();
        sb.append("{\"NICKNAME\":\"");
        sb.append(this.nickName);
        sb.append("\",\"CONTENT\":\"");
        sb.append(this.content);
        sb.append("\",\"TIME\":\"");
        sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.createTime));
        sb.append("\"}");
        return sb.toString();
    }
}
