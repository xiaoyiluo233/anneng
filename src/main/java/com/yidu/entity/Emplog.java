package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Emplog) 日志表实体类
 *
 * @author makejava
 * @since 2021-01-11 09:54:49
 */
@Component
public class Emplog implements Serializable {
    private static final long serialVersionUID = 138366208760298015L;
    
    private Integer elid;
    
    private Integer eid;
    
    private Integer type;
    
    private String message;
    
    private String times;

    @Override
    public String toString() {
        return "Emplog{" +
                "elid=" + elid +
                ", eid=" + eid +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", times='" + times + '\'' +
                '}';
    }

    public Emplog() {
    }

    public Emplog(Integer elid, Integer eid, Integer type, String message, String times) {
        this.elid = elid;
        this.eid = eid;
        this.type = type;
        this.message = message;
        this.times = times;
    }

    public Integer getElid() {
        return elid;
    }

    public void setElid(Integer elid) {
        this.elid = elid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

}