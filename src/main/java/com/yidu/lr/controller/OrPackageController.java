package com.yidu.lr.controller;

import com.yidu.entity.Orders;
import com.yidu.lr.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("OrPackage")
public class OrPackageController {

    //省服务对象
    @Resource
    private ProvinceService provinceService;

    //市服务对象
    @Resource
    private CityService cityService;

    //区服务对象
    @Resource
    private DistrictService districtService;

    //线路服务对象
    @Resource
    private PathService pathService;

    //订单服务对象
    @Resource
    private OrdersService ordersService;

    //地址服务对象
    @Resource
    private AddressService addressService;

    @GetMapping("selectAll")
    public List<Orders> selectAll(){
        List<Orders> orders = ordersService.queryAll(null);
        System.out.println("orders = " + orders);
        return orders;
    }
}
