package com.yidu.lr.controller.vo;

import com.yidu.entity.Path;
import com.yidu.entity.Trucks;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class RouteTrucksPathVo {
    private  int routeId;
    private Integer tid;
    private Integer pathid;
    private String tNumber;
    private Integer startId;
    private String startstationName;
    private String stationIds;
    private Integer endId;
    private String endstationName;
    private String startTime;
    private String arriveTime;
}
