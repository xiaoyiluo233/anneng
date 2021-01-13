package com.yidu.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Business)实体类
 *
 * @author makejava
 * @since 2021-01-08 14:24:53
 */
@Data
@Component
public class Business implements Serializable {
    private static final long serialVersionUID = 594858551001770909L;
    
    private Integer bid;
    
    private String bname;
    
    private String times;


    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

}