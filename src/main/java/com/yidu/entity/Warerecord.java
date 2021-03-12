package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @description: 仓库记录表实体类
 * @author: lixiang
 * @date: 2021/3/11 18:26
 * @version 1.0
 */
@Component
public class Warerecord implements Serializable {
    private static final long serialVersionUID = -66637062385190467L;
    
    private Integer wrid;
    
    private Integer wid;
    
    private Integer oid;
    
    private Integer eid;
    
    private String times;
    
    private Integer state;


    public Integer getWrid() {
        return wrid;
    }

    public void setWrid(Integer wrid) {
        this.wrid = wrid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}