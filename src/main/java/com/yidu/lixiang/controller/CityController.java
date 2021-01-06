package com.yidu.lixiang.controller;

import com.yidu.entity.City;
import com.yidu.lixiang.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 市级表控制层
 * @author: lixiang
 * @date: 2020/12/30 15:18
 * @version 1.0
 */
@Controller
public class CityController {
    /**
     * 服务对象
     */
    @Autowired
    private CityService cityService;

    @ResponseBody
    @RequestMapping(value = "city_getProvinceName",produces = {("application/json;charset=utf-8")})
    public String getProvinceName(City city){
        return cityService.getProvinceName(city);
    }

    @ResponseBody
    @RequestMapping("city_getProvince")
    public List<City> getProvince(City city){
        return cityService.getProvince(city);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("city_selectOne")
    @ResponseBody
    public City selectOne(Integer id) {
        return this.cityService.queryById(id);
    }

}