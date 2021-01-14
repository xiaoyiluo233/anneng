package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @description: 线路表实体类
 * @author: lixiang
 * @date: 2020/12/31 11:01
 * @version 1.0
 */
@Component
public class Path implements Serializable {
    private static final long serialVersionUID = -71825607840554894L;

    private Integer pathid;

    private Integer startstation;

    private String stationids;

    private Integer destination;

    private Station station;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "Path{" +
                "pathid=" + pathid +
                ", startstation=" + startstation +
                ", stationids='" + stationids + '\'' +
                ", destination=" + destination +
                '}';
    }

    public Integer getPathid() {
        return pathid;
    }

    public void setPathid(Integer pathid) {
        this.pathid = pathid;
    }

    public Integer getStartstation() {
        return startstation;
    }

    public void setStartstation(Integer startstation) {
        this.startstation = startstation;
    }

    public String getStationids() {
        return stationids;
    }

    public void setStationids(String stationids) {
        this.stationids = stationids;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

}