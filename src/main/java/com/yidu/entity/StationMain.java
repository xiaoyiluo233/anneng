package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 *@description: 具体的中转站
 *@author:lixiang
 *@date: 2020/12/31 16:28
 *@vesion:1.0
 */
@Component
public class StationMain implements Serializable {

    private Integer pathId;

    private String startStation;

    private String stationsCenter;

    private String destinationName;

    public StationMain() {
    }

    @Override
    public String toString() {
        return "StationMain{" +
                "pathId=" + pathId +
                ", startStation='" + startStation + '\'' +
                ", stationsCenter='" + stationsCenter + '\'' +
                ", destinationName='" + destinationName + '\'' +
                '}';
    }

    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getStationsCenter() {
        return stationsCenter;
    }

    public void setStationsCenter(String stationsCenter) {
        this.stationsCenter = stationsCenter;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }
}
