/*
 * @title: Template.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午2:01:12
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Template
 * @description 模板
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_TEMPLATE")
public class Template extends Domain {

    @Id
    private Integer tId;
    @Column
    private String name;
    @Column
    private String content;
    @Column
    private Date createTime;
    /**
     * @return 模板ID
     */
    public final Integer gettId() {
        return tId;
    }
    /**
     * @param tId 模板ID
     */
    public final void settId(Integer tId) {
        this.tId = tId;
    }
    /**
     * @return 模板名称
     */
    public final String getName() {
        return name;
    }
    /**
     * @param name 模板名称
     */
    public final void setName(String name) {
        this.name = name;
    }
    /**
     * @return 模板内容
     */
    public final String getContent() {
        return content;
    }
    /**
     * @param content 模板内容
     */
    public final void setContent(String content) {
        this.content = content;
    }
    /**
     * @return 创建时间
     */
    public final Date getCreateTime() {
        return createTime;
    }
    /**
     * @param createTime 创建时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
}
