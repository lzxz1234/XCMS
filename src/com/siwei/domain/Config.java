/*
 * @title: Config.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:23:09
 * @version V1.0
 */
package com.siwei.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Config
 * @description 系统配置
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_CONFIG")
public class Config {

    @Name
    private String keyName;
    @Column
    private String keyValue;
    
    /**
     * @return 参数名
     */
    public final String getKeyName() {
        return keyName;
    }
    /**
     * @param keyName 参数名
     */
    public final void setKeyName(String keyName) {
        this.keyName = keyName;
    }
    /**
     * @return 参数值
     */
    public final String getKeyValue() {
        return keyValue;
    }
    /**
     * @param keyValue 参数值
     */
    public final void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }
    
}
