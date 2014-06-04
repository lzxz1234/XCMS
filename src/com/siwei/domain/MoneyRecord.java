/*
 * @title: MoneyRecord.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:37:58
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class MoneyRecord
 * @description 用户帐户流水记录
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_MOENY_RECORD")
public class MoneyRecord extends Domain {

    @Id
    private Long mId;
    @Column
    private Long userId;
    @Column
    private double money;
    @Column
    private Integer type;
    @Column
    private Date createTime;
    @Column
    private Integer channel;
    @Column
    private Long rId;
    @Column
    private Integer chId;
    @Column(value="descriotion")
    private String description;
    
    @One(target=User.class, field="userId")
    private User user;
    
    public final User getUser() {
        return user;
    }
    public final void setUser(User user) {
        this.user = user;
    }
    /**
     * @return 流水ID
     */
    public final Long getmId() {
        return mId;
    }
    /**
     * @param mId 流水ID
     */
    public final void setmId(Long mId) {
        this.mId = mId;
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
     * @return 金额
     */
    public final double getMoney() {
        return money;
    }
    /**
     * @param money 金额
     */
    public final void setMoney(double money) {
        this.money = money;
    }
    /**
     * @return 类型
     */
    public final Integer getType() {
        return type;
    }
    /**
     * @param type 类型
     */
    public final void setType(Integer type) {
        this.type = type;
    }
    /**
     * @return 时间
     */
    public final Date getCreateTime() {
        return createTime;
    }
    /**
     * @param createTime 时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * @return 渠道
     */
    public final Integer getChannel() {
        return channel;
    }
    /**
     * @param channel 渠道
     */
    public final void setChannel(Integer channel) {
        this.channel = channel;
    }
    /**
     * @return 消费目标ID
     */
    public final Long getrId() {
        return rId;
    }
    /**
     * @param rId 消费目标ID
     */
    public final void setrId(Long rId) {
        this.rId = rId;
    }
    /**
     * @return 消费章节ID
     */
    public final Integer getChId() {
        return chId;
    }
    /**
     * @param chId 消费章节ID
     */
    public final void setChId(Integer chId) {
        this.chId = chId;
    }
    /**
     * @return 描述
     */
    public final String getDescription() {
        return description;
    }
    /**
     * @param description 描述
     */
    public final void setDescription(String description) {
        this.description = description;
    }
    
}
