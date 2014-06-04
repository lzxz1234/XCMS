/*
 * @title: Column.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:13:42
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Column
 * @description 栏目
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_COLUMN")
public class SColumn extends Domain {

    @Id
    private Long cId;
    @Column
    private String name;
    @Column
    private Long parentId;
    @Column
    private Date createTime;
    @Column("TID")
    private Integer tId;
    @Column("DID")
    private Integer dId;
    @Column 
    private String cover;
    @Column
    private int type;
    @Column
    private String remark;
    
    @ManyMany(target=Resource.class, relation="S_COLUMN_RESOURCE", from="C_ID", to="ID")
    private List<Resource> resourceList;
    @One(target=SColumn.class, field="parentId")
    private SColumn parent;
    
    public final SColumn getParent() {
        return parent;
    }
    public final void setParent(SColumn parent) {
        this.parent = parent;
    }
    public final Long getParentId() {
        return parentId;
    }
    public final void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public final String getCover() {
        return cover;
    }
    public final void setCover(String cover) {
        this.cover = cover;
    }
    /**
     * @return 资源
     */
    public final List<Resource> getResourceList() {
        return resourceList;
    }
    /**
     * @param resourceList 资源
     */
    public final void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
    
    /**
     * @return 栏目ID
     */
    public final Long getcId() {
        return cId;
    }
    /**
     * @param cId 栏目ID
     */
    public final void setcId(Long cId) {
        this.cId = cId;
    }
    /**
     * @return 栏目名称
     */
    public final String getName() {
        return name;
    }
    /**
     * @param name 栏目名称
     */
    public final void setName(String name) {
        this.name = name;
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
    /**
     * @return 栏目模板ID
     */
    public final Integer gettId() {
        return tId;
    }
    /**
     * @param tId 栏目模板ID
     */
    public final void settId(Integer tId) {
        this.tId = tId;
    }
    /**
     * @return 详情页模板ID
     */
    public final Integer getdId() {
        return dId;
    }
    /**
     * @param dId 详情页模板ID
     */
    public final void setdId(Integer dId) {
        this.dId = dId;
    }
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}
