/*
 * @title: Chapter.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 上午11:02:30
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Chapter
 * @description 图书章节表
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_CHAPTER")
public class Chapter extends Domain {

    @Id
    private Long id;
    @Column
    private Integer seq;
    @Column
    private String name;
    @Column
    private String content;
    @Column
    private Long pid;
    @Column
    private Long bookId;
    @Column
    private Integer hitCount;
    @Column
    private Integer status;
    @Column
    private Date createTime;
    @Column 
    private String keyword;
    @Column
    private int price;
    
    @One(target=Chapter.class, field="pid")
    private Chapter chapter;
    @One(target=Book.class, field="bookId")
    private Book book;
    @One(target=Resource.class, field="bookId")
    private Resource resource;
    @Many(target=Comment.class, field="id")
    private List<Comment> commentList;
    
    public final Date getCreateTime() {
        return createTime;
    }
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public final Chapter getChapter() {
        return chapter;
    }
    public final void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
    public final Book getBook() {
        return book;
    }
    public final void setBook(Book book) {
        this.book = book;
    }
    public final Resource getResource() {
        return resource;
    }
    public final void setResource(Resource resource) {
        this.resource = resource;
    }
    public final List<Comment> getCommentList() {
        return commentList;
    }
    public final void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    
    public final String getKeyword() {
        return keyword;
    }
    public final void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    /**
     * @return 章节ID
     */
    public final Long getId() {
        return id;
    }
    /**
     * @param id 章节ID
     */
    public final void setId(Long id) {
        this.id = id;
    }
    /**
     * @return 章节顺序
     */
    public final Integer getSeq() {
        return seq;
    }
    /**
     * @param seq 章节顺序
     */
    public final void setSeq(Integer seq) {
        this.seq = seq;
    }
    /**
     * @return 章节名称
     */
    public final String getName() {
        return name;
    }
    /**
     * @param name 章节名称
     */
    public final void setName(String name) {
        this.name = name;
    }
    /**
     * @return 章节内容
     */
    public final String getContent() {
        return content;
    }
    /**
     * @param content 章节内容
     */
    public final void setContent(String content) {
        this.content = content;
    }
    /**
     * @return 父章节ID
     */
    public final Long getPid() {
        return pid;
    }
    /**
     * @param pid 父章节ID
     */
    public final void setPid(Long pid) {
        this.pid = pid;
    }
    /**
     * @return 图书ID
     */
    public final Long getBookId() {
        return bookId;
    }
    /**
     * @param bookId 图书ID
     */
    public final void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    /**
     * @return 点击量
     */
    public final Integer getHitCount() {
        return hitCount;
    }
    /**
     * @param hitCount 点击量
     */
    public final void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }
    /**
     * @return 状态
     */
    public final Integer getStatus() {
        return status;
    }
    /**
     * @param status 状态
     */
    public final void setStatus(Integer status) {
        this.status = status;
    }
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
    
}
