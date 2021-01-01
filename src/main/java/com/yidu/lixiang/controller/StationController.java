package com.yidu.lixiang.controller;

import com.yidu.entity.Station;
import com.yidu.lixiang.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 中转站表控制层
 * @author: lixiang
 * @date: 2020-12-28 15:00:00
 * @version 1.0
 */
@Controller
public class StationController {
    /**
     * 服务对象
     */
    @Autowired
    private StationService stationService;

    @ResponseBody
    @RequestMapping("station_stationAndCity")
    public List<Station> stationAndCity(){
        return stationService.stationAndCity(null);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("station_selectOne")
    @ResponseBody
    public Station selectOne(Integer id) {
        return this.stationService.queryById(id);
    }

}