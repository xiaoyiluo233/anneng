package com.yidu.lr.controller.vo;

import com.yidu.entity.Path;
import com.yidu.entity.Trucks;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class RouteTrucksPathVo {
    private  int routeId;
    private String tNumber;
    private String startstationName;
    private String stationIds;
    private String endstationName;
    private String startTime;
    private String arriveTime;
}
