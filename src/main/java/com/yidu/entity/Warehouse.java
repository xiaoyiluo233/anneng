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

}