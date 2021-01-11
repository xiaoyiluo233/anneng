package com.yidu.entity;

import org.springframework.stereotype.Controller;

import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2021-01-06 08:36:38
 */
@Controller
public class Product implements Serializable {
    private static final long serialVersionUID = -67664774417573639L;
    
    private Integer pid;
    
    private String pvalue;
    
    private Integer uid;
    
    private Integer ptid;
    
    private Integer pwid;
    
    private Integer myaid;
    
    private Integer youaid;
    
    private String times;
    
    private double weight;
    
    private Integer state;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public Integer getPwid() {
        return pwid;
    }

    public void setPwid(Integer pwid) {
        this.pwid = pwid;
    }

    public Integer getMyaid() {
        return myaid;
    }

    public void setMyaid(Integer myaid) {
        this.myaid = myaid;
    }

    public Integer getYouaid() {
        return youaid;
    }

    public void setYouaid(Integer youaid) {
        this.youaid = youaid;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}