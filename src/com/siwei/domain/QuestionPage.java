/*
 * @title: QuestionPage.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午1:41:49
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
 * @class QuestionPage
 * @description 调查问卷
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_QUESTION_PAGE")
public class QuestionPage extends Domain {

    @Id
    private Integer pId;
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private String Integerro;
    @Column
    private Integer position;
    
    @One(target=Manager.class, field="id")
    private Manager manager;
    @Many(target=Question.class, field="pId")
    private List<Question> questionList;
    
    public final List<Question> getQuestionList() {
        return questionList;
    }
    public final void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
    public final Manager getManager() {
        return manager;
    }
    public final void setManager(Manager manager) {
        this.manager = manager;
    }
    /**
     * @return 问卷ID
     */
    public final Integer getpId() {
        return pId;
    }
    /**
     * @param pId 问卷ID
     */
    public final void setpId(Integer pId) {
        this.pId = pId;
    }
    /**
     * @return 管理员ID
     */
    public final Integer getId() {
        return id;
    }
    /**
     * @param id 管理员ID
     */
    public final void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return 问卷名称
     */
    public final String getTitle() {
        return title;
    }
    /**
     * @param title 问卷名称
     */
    public final void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return 问卷介绍
     */
    public final String getIntegerro() {
        return Integerro;
    }
    /**
     * @param Integerro 问卷介绍
     */
    public final void setIntegerro(String Integerro) {
        this.Integerro = Integerro;
    }
    /**
     * @return 问卷位置标志
     */
    public final Integer getPosition() {
        return position;
    }
    /**
     * @param position 问卷位置标志
     */
    public final void setPosition(Integer position) {
        this.position = position;
    }
    
}
