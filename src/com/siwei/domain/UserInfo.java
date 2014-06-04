/*
 * @title: UserInfo.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午2:12:46
 * @version V1.0
 */
package com.siwei.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class UserInfo
 * @description 用户扩展信息
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_USERINFO")
public class UserInfo extends Domain {

    @Id(auto=false)
    private Integer userId;
    @Column
    private Integer money;
    
    @One(target=User.class, field="userId")
    private User user;
    
    public final User getUser() {
        return user;
    }
    public final void setUser(User user) {
        this.user = user;
    }
    /**
     * @return 用户ID
     */
    public final Integer getUserId() {
        return userId;
    }
    /**
     * @param userId 用户ID
     */
    public final void setUserId(Integer userId) {
        this.userId = userId;
    }
    /**
     * @return 余额
     */
    public final Integer getMoney() {
        return money;
    }
    /**
     * @param money 余额
     */
    public final void setMoney(Integer money) {
        this.money = money;
    }
    
}
