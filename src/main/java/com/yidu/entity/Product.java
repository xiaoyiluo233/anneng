package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2021-01-11 11:13:04
 */
@Component
public class Product implements Serializable {
    private static final long serialVersionUID = -47091595889459753L;
    
    private Integer pid;
    
    private String pvalue;
    
    private Integer uid;
    
    private Integer ptid;
    
    private Integer pwid;
    
    private Integer myaid;
    
    private Integer youaid;
    
    private String times;
    
    private Double weight;
    
    private Integer toOrders;
    
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getToOrders() {
        return toOrders;
    }

    public void setToOrders(Integer toOrders) {
        this.toOrders = toOrders;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}