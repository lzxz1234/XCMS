/*
 * @title: SightReading.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-7-5 下午3:44:01
 * @version V1.0
 */
package com.siwei.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.json.JsonFormat;
import org.nutz.json.ToJson;

/**
 * @class SightReading
 * @description 情景阅读
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@ToJson
@Table("S_SIGHT_READING")
public class SightReading extends Domain {

    @Id
    private Integer id;
    @Column
    private String keyword;
    @Column
    private String bgUrl;
    @Column
    private String musicUrl;
    @Column
    private Integer status;
    /**
     * @return ID
     */
    public final Integer getId() {
        return id;
    }
    /**
     * @param id ID
     */
    public final void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return 关键字
     */
    public final String getKeyword() {
        return keyword;
    }
    /**
     * @param keyword 关键字
     */
    public final void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    /**
     * @return 背景图地址
     */
    public final String getBgUrl() {
        return bgUrl;
    }
    /**
     * @param bgUrl 背景图地址
     */
    public final void setBgUrl(String bgUrl) {
        this.bgUrl = bgUrl;
    }
    /**
     * @return 背景音乐
     */
    public final String getMusicUrl() {
        return musicUrl;
    }
    /**
     * @param musicUrl 背景音乐
     */
    public final void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }
    /**
     * @return 状态<br>
     * 1：生效
2：失效
     */
    public final Integer getStatus() {
        return status;
    }
    /**
     * @param status 状态<br>
     * 1：生效
2：失效
     */
    public final void setStatus(Integer status) {
        this.status = status;
    }
    
    public String toJson(JsonFormat format) {
        
        StringBuilder sb = new StringBuilder();
        sb.append("{\"KEYWORD\":\"");
        sb.append(this.keyword);
        sb.append("\",\"PICTURE\":\"");
        sb.append(this.bgUrl);
        sb.append("\",\"MUSIC\":\"");
        sb.append(this.musicUrl);
        sb.append("\"}");
        return sb.toString();
    }
}
