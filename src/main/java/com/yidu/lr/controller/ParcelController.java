package com.yidu.lr.controller;

import com.yidu.entity.Orders;
import com.yidu.entity.Parcel;
import com.yidu.entity.Station;
import com.yidu.lr.controller.vo.ParcelStationVo;
import com.yidu.lr.service.OrdersService;
import com.yidu.lr.service.ParcelService;
import com.yidu.lr.service.StationService;
import com.yidu.lr.service.impl.LRAddressServiceImpl;
import com.yidu.lr.service.impl.LROrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: 包裹表控制层
 * @author: lr
 * @date: 2020/12/30 15:18
 * @version 1.0
 */
@RestController
@RequestMapping("parcel")
public class ParcelController {
    //包裹服务对象
    @Resource
    ParcelService parcelService;
    //订单服务对象
    @Autowired
    LROrdersServiceImpl ordersService;
    //中转站服务对象
    @Resource
    StationService stationService;

    /**
     * 查询所有
     * @return 信息列表
     */
    @GetMapping("selectAll")
    public List<Parcel> selectAll(){
        return parcelService.queryAll(null);
    }

    /**
     * 连表查询包裹信息
     * @return 信息列表
     */
    @GetMapping("selectConnect")
    public List<ParcelStationVo> selectConnect(){
        return parcelService.selectConnect();
    }

    /**
     * 根据字符串查询订单信息
     * @param value
     * @return 信息列表
     */
    @GetMapping("selectMap")
    public List<Map<String,Object>> queryByOidMap(String value){
        //截取字符串
        String[] str=value.split("-");
        //根据截取的id查询订单信息
        List<Map<String,Object>> stringObjectMap = parcelService.OidFindIn(str);
        //返回订单列表信息
        return stringObjectMap;
    }

    /**
     * 新增包裹信息
     * @param parcel
     * @return boolean
     */
    @PostMapping("insert")
    public boolean insert(Parcel parcel){
        parcelService.insert(parcel);
        return true;
    }

    /**
     * 修改包裹信息
     * @param parcel
     * @return  boolean
     */
    @PostMapping("update")
    public boolean update(Parcel parcel){
        parcelService.update(parcel);
        return true;
    }

    /**
     * 根据id删除包裹信息
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    public boolean delete(String id){
        //截取id
        String[] split = id.split(",");
        //循环id
        for (int i = 0; i < split.length; i++) {
            //根据id删除包裹信息
            boolean delete = parcelService.deleteById(Integer.parseInt(split[i]));
        }
        //返回信息
        return true;
    }

    /**
     * 查询所有中转站、订单信息
     * @return map信息列表
     */
    @GetMapping("selectOAS")
    public Map<String,Object> selectOrders(){
        //创建map集合
        Map<String,Object> map=new HashMap<>();
        //查询所有中转站信息保存map集合
        map.put("station",stationService.queryAll(null));
        //查询所有订单信息保存map集合
        map.put("orders",ordersService.queryAll(null));
        //返回map
        return map;
    }

}
