/*
 * @title: Book.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 涓婂崍10:59:05
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Book
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_BOOK")
public class Book extends Domain {

    @Id(auto=false)
    private Long id;
    @Column
    private String isbn;
    @Column
    private String press;
    @Column
    private Date pubTime;
    
    @One(target=Resource.class, field="id")
    private Resource resource;
    @Many(field="bookId", key="id", target=Chapter.class)
    private List<Chapter> chapterList;
    
    public final Resource getResource() {
        return resource;
    }
    public final void setResource(Resource resource) {
        this.resource = resource;
    }
    
    @ManyMany(target=SColumn.class, relation="S_COLUMN_RESOURCE", from="ID", to="C_ID")
    private List<SColumn> columnList;
    @ManyMany(target=ContentPool.class, relation="S_C_R", from="ID", to="S_C_ID")
    private List<ContentPool> contentPoolList;
    @ManyMany(target=Sort.class, relation="S_SORT_RELATION", from="ID", to="S_S_ID")
    private List<Sort> sortList;
    
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
    
    public final List<Chapter> getChapterList() {
        return chapterList;
    }
    public final void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }
    /**
     * @return the id
     */
    public final Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public final void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the author
     
    public final String getAuthor() {
        return author;
    }
    /**
     * @param author the author to set
     
    public final void setAuthor(String author) {
        this.author = author;
    }
    /**
     * @return the isbn
     */
    public final String getIsbn() {
        return isbn;
    }
    /**
     * @param isbn the isbn to set
     */
    public final void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * @return the press
     */
    public final String getPress() {
        return press;
    }
    /**
     * @param press the press to set
     */
    public final void setPress(String press) {
        this.press = press;
    }
    /**
     * @return the pubTime
     */
    public final Date getPubTime() {
        return pubTime;
    }
    /**
     * @param pubTime the pubTime to set
     */
    public final void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }
    /**
     * @return the cover
     
    public final String getCover() {
        return cover;
    }
    /**
     * @param cover the cover to set
     
    public final void setCover(String cover) {
        this.cover = cover;
    }*/
    
}
