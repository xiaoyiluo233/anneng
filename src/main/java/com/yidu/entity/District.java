package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * @description: 县级表实体类
 * @author: lixiang
 * @date: 2020/12/30 15:45
 * @version 1.0
 */
@Component
public class District implements Serializable {
    private static final long serialVersionUID = -75182080197621226L;
    
    private Integer districtid;
    
    private Integer provinceid;
    
    private Integer cityid;
    
    private String districtname;

    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "District{" +
                "districtid=" + districtid +
                ", provinceid=" + provinceid +
                ", cityid=" + cityid +
                ", districtname='" + districtname + '\'' +
                '}';
    }

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

}