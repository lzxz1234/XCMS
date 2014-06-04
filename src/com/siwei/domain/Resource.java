/*
 * @title: Resource.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 上午9:12:34
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Resource
 * @description 资源表
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table(value = "S_RESOURCE")
public class Resource extends Domain {

    @Id
    private Long id;
    @Column
    private Integer type;
    @Column
    private String name;
    @Column
    private String remark;
    @Column
    private String url;
    @Column
    private boolean comment;
    @Column
    private Integer status;
    @Column
    private Integer hitCount;
    @Column
    private String keyword;
    @Column("5_HITS")
    private Integer fiveHit;
    @Column("4_HITS")
    private Integer fourHit;
    @Column("3_HITS")
    private Integer threeHit;
    @Column("2_HITS")
    private Integer twoHit;
    @Column("1_HITS")
    private Integer oneHit;
    @Column
    private Integer grade;
    @Column
    private Integer favCount;
    @Column
    private String cover;
    @Column
    private String author;
    @Column
    private Date createTime;
    @Column
    private Integer price;
    @Column
    private String intro;
    @Column
    private Date updateTime;
    @Column
    private String recommand;
    @Column
    private Integer createType;
    @Column
    private Long creator;
    
    @One(target=Book.class, field="id")
    private Book book;
    
    @One(target=File.class, field="id")
    private File file;
    
    public final Book getBook() {
		return book;
	}
	public final void setBook(Book book) {
		this.book = book;
	}
	
	@Many(target=Chapter.class, field = "bookId")
	private List<Chapter> chapterList;
	@Many(target=Comment.class, field = "resId")
	private List<Comment> commentList;
	@Many(target=SaleRecord.class, field = "id")
	private List<SaleRecord> saleRecordList;
	@Many(target=UserOrder.class, field = "id")
	private List<UserOrder> userOrderList;
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public final List<Chapter> getChapterList() {
		return chapterList;
	}
	public final void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}
	
	public final List<Comment> getCommentList() {
		return commentList;
	}
	public final void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
    
    @ManyMany(target=SColumn.class, relation="S_COLUMN_RESOURCE", from="ID", to="C_ID")
    private List<SColumn> columnList;
    @ManyMany(target=ContentPool.class, relation="S_C_R", from="ID", to="S_C_ID")
    private List<ContentPool> contentPoolList;
    @ManyMany(target=Sort.class, relation="S_SORT_RELATION", from="ID", to="S_S_ID")
    private List<Sort> sortList;
    @ManyMany(target=User.class, relation="S_BOOKMARK", from="ID", to="S_U_ID")
    private List<User> userList;
    
    public final List<ContentPool> getContentPoolList() {
        return contentPoolList;
    }
    public final void setContentPoolList(List<ContentPool> contentPoolList) {
        this.contentPoolList = contentPoolList;
    }
    public final List<Sort> getSortList() {
        return sortList;
    }
    public final void setSortList(List<Sort> sortList) {
        this.sortList = sortList;
    }
    public final List<SColumn> getColumnList() {
        return columnList;
    }
    public final void setColumnList(List<SColumn> columnList) {
        this.columnList = columnList;
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
     * @return 资源类型
     * 1=资讯 2=图书 3=图片 4=音频 5=视频 6=问卷 7=活动 8=任务 9=驻地资源
     */
    public final Integer getType() {
        return type;
    }
    /**
     * @param type 资源类型
     * 1=资讯 2=图书 3=图片 4=音频 5=视频 6=问卷 7=活动 8=任务 9=驻地资源
     */
    public final void setType(Integer type) {
        this.type = type;
    }
    /**
     * @return 资源名称
     */
    public final String getName() {
        return name;
    }
    /**
     * @param name 资源名称
     */
    public final void setName(String name) {
        this.name = name;
    }
    /**
     * @return 备注
     */
    public final String getRemark() {
        return remark;
    }
    /**
     * @param remark 备注
     */
    public final void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * @return 访问地址
     */
    public final String getUrl() {
        return url;
    }
    /**
     * @param url 访问地址
     */
    public final void setUrl(String url) {
        this.url = url;
    }
    /**
     * @return 允许评论
     */
    public final boolean isComment() {
        return comment;
    }
    /**
     * @param comment 允许评论
     */
    public final void setComment(boolean comment) {
        this.comment = comment;
    }
    /**
     * @return 资源状态
     */
    public final Integer getStatus() {
        return status;
    }
    /**
     * @param status 资源状态
     */
    public final void setStatus(Integer status) {
        this.status = status;
    }
    /**
     * @return 点击量
     */
    public final Integer getHitCount() {
        return hitCount == null ? Integer.valueOf(1) : hitCount;
    }
    /**
     * @param hitCount 点击量
     */
    public final void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }
    /**
     * @return 关键词
     */
    public final String getKeyword() {
        return keyword;
    }
    /**
     * @param keyword 关键词
     */
    public final void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    /**
     * @return 好评5数
     */
    public final Integer getFiveHit() {
        return fiveHit == null ? Integer.valueOf(0) : fiveHit;
    }
    /**
     * @param fiveHit 好评5数
     */
    public final void setFiveHit(Integer fiveHit) {
        this.fiveHit = fiveHit;
    }
    /**
     * @return 好评4数
     */
    public final Integer getFourHit() {
        return fourHit == null ? Integer.valueOf(0) : fourHit;
    }
    /**
     * @param fourHit 好评4数
     */
    public final void setFourHit(Integer fourHit) {
        this.fourHit = fourHit;
    }
    /**
     * @return 好评3数
     */
    public final Integer getThreeHit() {
        return threeHit == null ? Integer.valueOf(0) : threeHit;
    }
    /**
     * @param threeHit 好评3数
     */
    public final void setThreeHit(Integer threeHit) {
        this.threeHit = threeHit;
    }
    /**
     * @return 好评2数
     */
    public final Integer getTwoHit() {
        return twoHit == null ? Integer.valueOf(0) : twoHit;
    }
    /**
     * @param twoHit 好评2数
     */
    public final void setTwoHit(Integer twoHit) {
        this.twoHit = twoHit;
    }
    /**
     * @return 好评1数
     */
    public final Integer getOneHit() {
        return oneHit == null ? Integer.valueOf(0) : oneHit;
    }
    /**
     * @param oneHit 好评1数
     */
    public final void setOneHit(Integer oneHit) {
        this.oneHit = oneHit;
    }
    /**
     * @return 综合评价分数
     */
    public final Integer getGrade() {
        return grade;
    }
    /**
     * @param grade 综合评价分数
     */
    public final void setGrade(Integer grade) {
        this.grade = grade;
    }
    /**
     * @return 收藏数
     */
    public final Integer getFavCount() {
        return favCount == null ? Integer.valueOf(0) : favCount;
    }
    /**
     * @param favCount 收藏数
     */
    public final void setFavCount(Integer favCount) {
        this.favCount = favCount;
    }
	/**
	 * @return the cover
	 */
	public String getCover() {
		return cover;
	}
	/**
	 * @param cover the cover to set
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public final String getRecommand() {
		return recommand;
	}
	public final void setRecommand(String recommand) {
		this.recommand = recommand;
	}
	public final String getIntro() {
		return intro;
	}
	public final void setIntro(String intro) {
		this.intro = intro;
	}
	public final List<User> getUserList() {
		return userList;
	}
	public final void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public final List<SaleRecord> getSaleRecordList() {
		return saleRecordList;
	}
	public final void setSaleRecordList(List<SaleRecord> saleRecordList) {
		this.saleRecordList = saleRecordList;
	}
	public final List<UserOrder> getUserOrderList() {
		return userOrderList;
	}
	public final void setUserOrderList(List<UserOrder> userOrderList) {
		this.userOrderList = userOrderList;
	}
	public final File getFile() {
		return file;
	}
	public final void setFile(File file) {
		this.file = file;
	}
	/**
	 * @return the createType
	 */
	public Integer getCreateType() {
		return createType;
	}
	/**
	 * @param createType the createType to set
	 */
	public void setCreateType(Integer createType) {
		this.createType = createType;
	}
	/**
	 * @return the creator
	 */
	public Long getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	
    
}
