package com.yidu.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * (Warehouse)入库表实体类
 *
 * @author makejava
 * @since 2020-12-31 13:53:27
 */
@Component
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 537506291001543621L;
    
    private Integer wid;
    
    private String wname;
    
    private String oid;
    
    private String times;
    
    private Integer state;


    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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