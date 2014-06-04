/*
 * @title: Book.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 涓婂崍10:59:05
 * @version V1.0
 */
package com.siwei.domain;

import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.json.JsonFormat;
import org.nutz.json.ToJson;

/**
 * @class BookMark
 * @author jibaogang
 * @version v1.0
 */
@ToJson
@Table("S_BOOKMARK")
@PK({"sUId", "id"})
public class BookMark extends Domain {

    private Long id;
    private Long sUId;

    @One(target=Resource.class, field="id")
    private Resource resource;
   
    public final Resource getResource() {
        return resource;
    }
    public final void setResource(Resource resource) {
        this.resource = resource;
    }
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the rsUId
	 */
	public Long getSUId() {
		return sUId;
	}
	/**
	 * @param rsUId the rsUId to set
	 */
	public void setSUId(Long rsUId) {
		this.sUId = rsUId;
	}
 
	public String toJson(JsonFormat format) {
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append("{\"RID\":\"");
        sb.append(this.resource.getId());
        sb.append("\",\"NAME\":\"");
        sb.append(this.resource.getName());
        sb.append("\",\"TYPE\":\"");
        sb.append(this.resource.getType());
        sb.append("\",\"COVER\":\"");
        sb.append(this.resource.getCover());
        sb.append("\",\"AUTHOR\":\"");
        sb.append(this.resource.getAuthor());
        sb.append("\",\"INTRO\":\"");
        sb.append(this.resource.getIntro());
        sb.append("\"}");
	    return sb.toString();
	}
    
}
