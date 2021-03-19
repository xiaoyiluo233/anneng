package com.yidu.lr.controller.vo;

import lombok.Data;

@Data
public class ParcelStationVo {
    private int parcelId;
    private String oId;
    private int nextStation;
    private int upStation;
    private int state;
    private int nextStationId;
    private int upStationId;
    private int nextCityId;
    private int upCityId;
    private String nextStationName;
    private String upStationName;
    private int tid;
    private String tnumber;
}
