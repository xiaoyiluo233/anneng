package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @description: 中转表实体类
 * @author:lixiang
 * @date: 2020-12-28 14:59:35
 * @vesion:1.0
 */
@Component
public class Station implements Serializable {
    private static final long serialVersionUID = 492668398286826927L;
    
    private Integer stationid;
    
    private Integer cityid;
    
    private String stationname;

    private String persons;

    private String phones;

    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationid=" + stationid +
                ", cityid=" + cityid +
                ", stationname='" + stationname + '\'' +
                ", persons='" + persons + '\'' +
                ", phones='" + phones + '\'' +
                '}';
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
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