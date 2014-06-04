/*
 * @title: Answer.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 上午10:48:32
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Answer
 * @description 答题表
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_ANSWER")
public class Answer extends Domain {

    @Id
    private Long answerId;
    @Column
    private Long questionId;
    @Column
    private Long userId;
    @Column
    private String content;
    @Column
    private Date answerTime;
    
    @One(target=User.class, field="userId")
    private User user;
    @One(target=Question.class, field="questionId")
    private Question question;
    
    public final Question getQuestion() {
        return question;
    }
    public final void setQuestion(Question question) {
        this.question = question;
    }
    public final User getUser() {
        return user;
    }
    public final void setUser(User user) {
        this.user = user;
    }
    /**
     * @return the answerId
     */
    public final Long getAnswerId() {
        return answerId;
    }
    /**
     * @param answerId the answerId to set
     */
    public final void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }
    /**
     * @return 问题ID
     */
    public final Long getQuestionId() {
        return questionId;
    }
    /**
     * @param questionId 问题ID
     */
    public final void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    /**
     * @return 用户ID
     */
    public final Long getUserId() {
        return userId;
    }
    /**
     * @param userId 用户ID
     */
    public final void setUserId(Long userId) {
        this.userId = userId;
    }
    /**
     * @return 答题内容
     */
    public final String getContent() {
        return content;
    }
    /**
     * @param content 答题内容
     */
    public final void setContent(String content) {
        this.content = content;
    }
    /**
     * @return 答题时间
     */
    public final Date getAnswerTime() {
        return answerTime;
    }
    /**
     * @param answerTime 答题时间
     */
    public final void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }
    
    
}
