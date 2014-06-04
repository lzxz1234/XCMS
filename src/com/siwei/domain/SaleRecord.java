/*
 * @title: SaleRecord.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:44:38
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class SaleRecord
 * @description 交易记录
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_SALE_RECORD")
public class SaleRecord extends Domain {

    @Id
    private Long saleId;
    @Column
    private Long userId;
    @Column
    private Long id;
    @Column
    private Date createTime;
    @Column
    private Long destId;
    @Column
    private Integer money;
    @Column
    private Integer status;
    @Column
    private Date finishTime;
    
    @One(target=User.class, field="userId")
    private User user;
    @One(target=User.class, field="destId")
    private User destUser;
    @One(target=Resource.class, field="id")
    private Resource resource;
    @One(target=Book.class, field="id")
    private Book book;
    
    public final User getUser() {
        return user;
    }
    public final void setUser(User user) {
        this.user = user;
    }
    public final User getDestUser() {
        return destUser;
    }
    public final void setDestUser(User destUser) {
        this.destUser = destUser;
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
    /**
     * @return 交易ID
     */
    public final Long getSaleId() {
        return saleId;
    }
    /**
     * @param saleId 交易ID
     */
    public final void setSaleId(Long saleId) {
        this.saleId = saleId;
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
     * @return 图书ID
     */
    public final Long getId() {
        return id;
    }
    /**
     * @param id 图书ID
     */
    public final void setId(Long id) {
        this.id = id;
    }
    /**
     * @return 交易时间
     */
    public final Date getCreateTime() {
        return createTime;
    }
    /**
     * @param createTime 交易时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * @return 交易对象
     */
    public final Long getDestId() {
        return destId;
    }
    /**
     * @param destId 交易对象
     */
    public final void setDestId(Long destId) {
        this.destId = destId;
    }
    /**
     * @return 交易价格
     */
    public final Integer getMoney() {
        return money;
    }
    /**
     * @param money 交易价格
     */
    public final void setMoney(Integer money) {
        this.money = money;
    }
    /**
     * @return 1：申请交易
2：同意交易
3：交易完成
     */
    public final Integer getStatus() {
        return status;
    }
    /**
     * @param status 1：申请交易
2：同意交易
3：交易完成
     */
    public final void setStatus(Integer status) {
        this.status = status;
    }
    /**
     * @return 完成时间
     */
    public final Date getFinishTime() {
        return finishTime;
    }
    /**
     * @param finishTime 完成时间
     */
    public final void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
    
}
