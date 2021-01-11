package com.yidu.wt.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Prices)实体类
 *
 * @author makejava
 * @since 2021-01-06 08:36:24
 */
@Component
public class Prices implements Serializable {
    private static final long serialVersionUID = -30623617114820462L;
    
    private Integer priceid;
    
    private String pvalue;
    
    private double price;
    
    private Integer pid;
    
    private Integer days;


    public Integer getPriceid() {
        return priceid;
    }

    public void setPriceid(Integer priceid) {
        this.priceid = priceid;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

}