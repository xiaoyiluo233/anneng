package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Question)实体类
 *
 * @author makejava
 * @since 2021-01-08 14:52:34
 */
@Component
public class Question implements Serializable {
    private static final long serialVersionUID = -99290767099788829L;
    
    private Integer qid;
    
    private String question;
    
    private String answer;


    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}