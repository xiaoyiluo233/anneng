package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @description: 省级表实体类
 * @author:lixiang
 * @date: 2020-12-30 14:00:03
 * @vesion:1.0
 */
@Component
public class Province implements Serializable {
    private static final long serialVersionUID = 752800526270506156L;
    
    private Integer provinceid;
    
    private String provincename;

    @Override
    public String toString() {
        return "Province{" +
                "provinceid=" + provinceid +
                ", provincename='" + provincename + '\'' +
                '}';
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

}