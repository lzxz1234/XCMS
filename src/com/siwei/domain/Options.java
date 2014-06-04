/*
 * @title: Options.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 上午11:25:11
 * @version V1.0
 */
package com.siwei.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Options
 * @description 问题选项表
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_OPTIONS")
public class Options extends Domain {

    @Id
    private Long id;
    @Column
    private String content;
    @Column
    private Long questionId;
    
    @One(target=Question.class, field="questionId")
    private Question question;
    
    public final Question getQuestion() {
        return question;
    }
    public final void setQuestion(Question question) {
        this.question = question;
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
     * @return the content
     */
    public final String getContent() {
        return content;
    }
    /**
     * @param content the content to set
     */
    public final void setContent(String content) {
        this.content = content;
    }
    /**
     * @return the questionId
     */
    public final Long getQuestionId() {
        return questionId;
    }
    /**
     * @param questionId the questionId to set
     */
    public final void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    
}
