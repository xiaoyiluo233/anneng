package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
/**
 * @description: 市级表实体类
 * @author:lixiang
 * @date: 2020-12-30 14:00:15
 * @vesion:1.0
 */
@Component
public class City implements Serializable {
    private static final long serialVersionUID = 101549652111610251L;
    
    private Integer cityid;
    
    private Integer provinceid;
    
    private String cityname;

    private Province province;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityid=" + cityid +
                ", provinceid=" + provinceid +
                ", cityname='" + cityname + '\'' +
                '}';
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

}