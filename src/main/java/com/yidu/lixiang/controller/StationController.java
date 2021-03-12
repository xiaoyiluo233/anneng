package com.yidu.lixiang.controller;

import com.yidu.entity.City;
import com.yidu.entity.Station;
import com.yidu.lixiang.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
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

    /**
     * 连接前台页面的方法
     * @param city 市级实体类
     * @return ModelAndView
     */
    @RequestMapping("station_getStation")
    public ModelAndView getStation(City city){
        //创建一个返回类
        ModelAndView mv=new ModelAndView();
        //调用得到中转站的方法
        List<Station> stations = stationService.stationAndCity(city);
        //设置到返回类中
        mv.addObject("stations",stations);
        //设置返回页面
        mv.setViewName("frontPage/test");
        return mv;
    }

    /**
     * 根据id数组删除指定的中转站
     * @param stationids 中转站id数组
     * @return 删除成功
     */
    @RequestMapping(value = "station_delete",produces = {("application/json;charset=utf-8")})
    @ResponseBody
    public String delete(String stationids){
        return stationService.deleteById(stationids);
    }

    /**
     * 修改中转站的信息
     * @param station 中转站实体类
     * @param citynames 市级名
     * @return 修改成功
     */
    @ResponseBody
    @RequestMapping(value = "station_update",produces = {("application/json;charset=utf-8")})
    public String update(Station station,String citynames){
        return stationService.update(station, citynames);
    }

    /**
     * 新增中转站
     * @param station 中转站实体类
     * @param citynames 市级名
     * @return 新增成功
     */
    @ResponseBody
    @RequestMapping(value = "station_insert",produces = {("application/json;charset=utf-8")})
    public String insert(Station station,String citynames){
        return stationService.insert(station,citynames);
    }

    /**
     * 查出所有的中转站以及对应的市级
     * @param city 市级实体类
     * @return 中转站集合
     */
    @ResponseBody
    @RequestMapping("station_stationAndCity")
    public List<Station> stationAndCity(City city){
        return stationService.stationAndCity(city);
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("station_selectOne")
    @ResponseBody
    public Station selectOne(Integer id) {
        return this.stationService.queryById(id);
    }

}