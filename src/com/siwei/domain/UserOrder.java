/*
 * @title: UserOrder.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午2:10:05
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class UserOrder
 * @description 用户订购关系
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_USER_ORDER")
public class UserOrder {

    @Id
    private Long oId;
    @Column
    private Long userId;
    @Column
    private Long id;
    @Column
    private Long chaId;
    @Column
    private Integer oType;
    @Column
    private Date createTime;
    @One(target=Resource.class, field="id")
    private Resource resource;
    @One(target=User.class, field="userId")
    private User user;
    
    @One(target=Book.class, field="id")
    private Book book;
    @One(target=Chapter.class, field="chaId")
    private Chapter chapter;
    
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
    public final Book getBook() {
        return book;
    }
    public final void setBook(Book book) {
       this.book = book;
    }
    public final Chapter getChapter() {
        return chapter;
    }
    public final void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
    /**
     * @return 订购ID
     */
    public final Long getoId() {
        return oId;
    }
    /**
     * @param oId 订购ID
     */
    public final void setoId(Long oId) {
        this.oId = oId;
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
     * @return 图书章_章节ID
     */
    public final Long getChaId() {
        return chaId;
    }
    /**
     * @param chaId 图书章_章节ID
     */
    public final void setChaId(Long chaId) {
        this.chaId = chaId;
    }
    /**
     * @return 订购类型
     */
    public final Integer getoType() {
        return oType;
    }
    /**
     * @param oType 订购类型
     */
    public final void setoType(Integer oType) {
        this.oType = oType;
    }
    /**
     * @return 订购时间
     */
    public final Date getCreateTime() {
        return createTime;
    }
    /**
     * @param createTime 订购时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
}
