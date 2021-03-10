package com.yidu.lr.controller;

import com.yidu.entity.*;
import com.yidu.lr.service.impl.LRCityServiceImpl;
import com.yidu.lr.service.impl.LRDistrictServiceImpl;
import com.yidu.lr.service.impl.LRProvinceServiceImpl;
import com.yidu.lr.service.impl.LRStationServiceImpl;
import com.yidu.wt.service.impl.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("lr_order")
public class LrOrdersController {

    @Autowired
    private OrdersServiceImpl ordersService;
    @Autowired
    private LRProvinceServiceImpl provinceService;
    @Autowired
    private LRCityServiceImpl cityService;
    @Autowired
    private LRDistrictServiceImpl districtService;

    @Autowired
    private LRStationServiceImpl stationService;
    @RequestMapping("selectOrders")
    public boolean selectOrder(int id) {
        System.out.println("id = " + id);
        Orders orders = ordersService.queryById(id);
        System.out.println("orders = " + orders);
        if(orders==null){
            return false;
        }
        return true;
    }

    @RequestMapping("selectProvince")
    public List<Province> selectProvince() {
        return  provinceService.queryAll(null);
    }

    @RequestMapping("selectCity")
    public List<City> selectCity(Integer provinceid) {
        return  cityService.queryByProvinId(provinceid);
    }

    @RequestMapping("selectDistrict")
    public List<District> selectDistrict(Integer cityid) {
        return  districtService.queryByCityid(cityid);
    }

    @RequestMapping("queryByPCId")
    public List<Map<String, Object>> queryByPCId(Integer provinceid,Integer cityid,String province,String condition) {
        if(province!=null && province!=""){
            provinceid= provinceService.queryByProvinceName(province);
        }
        System.out.println("provinceid = " + provinceid + ", cityid = " + cityid + ", province = " + province + ", condition = " + condition);
        return  stationService.queryByPCId(provinceid,cityid,condition);
    }

    @RequestMapping("queryById")
    public Station queryById(Integer id) {
        return  stationService.queryById(id);
    }
}
