/*
 * @title: Question.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 上午11:26:45
 * @version V1.0
 */
package com.siwei.domain;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class Question
 * @description 问题表
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_QUESTION")
public class Question extends Domain {

    @Id
    private Long id;
    @Column
    private Integer pId;
    @Column
    private String topic;
    @Column
    private Integer type;
    
    @One(target=QuestionPage.class, field="pId")
    private QuestionPage questionPage;
    @Many(target=Options.class, field="questionId")
    private List<Options> optionList;
    
    public final List<Options> getOptionList() {
        return optionList;
    }
    public final void setOptionList(List<Options> optionList) {
        this.optionList = optionList;
    }
    public final QuestionPage getQuestionPage() {
        return questionPage;
    }
    public final void setQuestionPage(QuestionPage questionPage) {
        this.questionPage = questionPage;
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
     * @return the pId
     */
    public final Integer getpId() {
        return pId;
    }
    /**
     * @param pId the pId to set
     */
    public final void setpId(Integer pId) {
        this.pId = pId;
    }
    /**
     * @return the topic
     */
    public final String getTopic() {
        return topic;
    }
    /**
     * @param topic the topic to set
     */
    public final void setTopic(String topic) {
        this.topic = topic;
    }
    /**
     * @return the type
     */
    public final Integer getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public final void setType(Integer type) {
        this.type = type;
    }
    
}
