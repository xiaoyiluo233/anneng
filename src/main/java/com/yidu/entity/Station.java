package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Station)实体类
 *
 * @author lixiang
 * @since 2020-12-28 14:59:35
 */
@Component
public class Station implements Serializable {
    private static final long serialVersionUID = 492668398286826927L;
    
    private Integer stationid;
    
    private Integer cityid;
    
    private String stationname;

    @Override
    public String toString() {
        return "Station{" +
                "stationid=" + stationid +
                ", cityid=" + cityid +
                ", stationname='" + stationname + '\'' +
                '}';
    }

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }

}