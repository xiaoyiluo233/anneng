package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Prices)实体类
 *
 * @author makejava
 * @since 2021-01-08 16:26:49
 */
@Component
public class Prices implements Serializable {
    private static final long serialVersionUID = 151549521496606632L;
    
    private Integer priceid;
    
    private String pvalue;
    
    private Double price;
    
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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