package com.yidu.lixiang.controller;

import com.yidu.entity.Path;
import com.yidu.entity.StationMain;
import com.yidu.lixiang.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    /**
     * 根据id数组删除线路
     * @param ids 线路id数组
     * @return 删除成功
     */
    @RequestMapping(value = "path_delete",produces = {("application/json;charset=utf-8")})
    @ResponseBody
    public String delete(String ids){
        return pathService.deleteById(ids);
    }

    /**
     * 新增中转站
     * @param startStation 起点中转站
     * @param destinationName 终点中转站
     * @param stationCenters 经过的中转站
     * @return 新增成功
     */
    @ResponseBody
    @RequestMapping(value = "path_insert",produces = {("application/json;charset=utf-8")})
    public String insert(String startStation,String destinationName,String stationCenters){
        return pathService.insert(startStation, destinationName, stationCenters);
    }

    /**
     * 根据市级名查出中转站名数组
     * @param cityName 市级名
     * @return 中转站名数组
     */
    @RequestMapping("path_queryStation")
    @ResponseBody
    public String[] queryStation(String cityName){
        return pathService.queryStation(cityName);
    }

    /**
     * 查询所有的具体的中转站
     * @return 具体的中转站实体类
     */
    @ResponseBody
    @RequestMapping("path_queryAll")
    public List<StationMain> queryAll(){
        return pathService.queryAll();
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("path_selectOne")
    @ResponseBody
    public Path selectOne(Integer id) {
        return this.pathService.queryById(id);
    }

}