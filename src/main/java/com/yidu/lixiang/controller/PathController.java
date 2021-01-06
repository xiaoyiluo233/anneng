package com.yidu.lixiang.controller;

import com.yidu.entity.Path;
import com.yidu.entity.StationMain;
import com.yidu.lixiang.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @description: 线路表控制层
 * @author: lixiang
 * @date: 2020/12/31 11:05
 * @version 1.0
 */
@Controller
public class PathController {
    /**
     * 服务对象
     */
    @Autowired
    private PathService pathService;

    @RequestMapping(value = "path_delete",produces = {("application/json;charset=utf-8")})
    @ResponseBody
    public String delete(String ids){
        return pathService.deleteById(ids);
    }

    @ResponseBody
    @RequestMapping(value = "path_insert",produces = {("application/json;charset=utf-8")})
    public String insert(String startStation,String destinationName,String stationCenters){
        return pathService.insert(startStation, destinationName, stationCenters);
    }

    @RequestMapping("path_queryStation")
    @ResponseBody
    public String[] queryStation(String cityName){
        return pathService.queryStation(cityName);
    }

    @ResponseBody
    @RequestMapping("path_queryAll")
    public HashMap<String,Object> queryAll(Path path){
        return pathService.queryAll(path);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("path_selectOne")
    @ResponseBody
    public Path selectOne(Integer id) {
        return this.pathService.queryById(id);
    }

}