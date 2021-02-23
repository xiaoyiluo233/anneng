package com.yidu.lr.controller;

import com.yidu.entity.Orders;
import com.yidu.entity.Parcel;
import com.yidu.entity.Station;
import com.yidu.lr.controller.vo.ParcelStationVo;
import com.yidu.lr.service.OrdersService;
import com.yidu.lr.service.ParcelService;
import com.yidu.lr.service.StationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("parcel")
public class ParcelController {

    @Resource
    ParcelService parcelService;

    @Resource
    OrdersService ordersService;

    @Resource
    StationService stationService;

    @GetMapping("selectAll")
    public List<Parcel> selectAll(){
        return parcelService.queryAll(null);
    }

    @GetMapping("selectConnect")
    public List<ParcelStationVo> selectConnect(){
        return parcelService.selectConnect();
    }

    @GetMapping("selectMap")
    public List<Map<String,Object>> queryByOidMap(String value){
        String[] str=value.split("-");
        List<Map<String,Object>> stringObjectMap = parcelService.OidFindIn(str);
        return stringObjectMap;
    }

    @PostMapping("insert")
    public boolean insert(Parcel parcel){
        parcelService.insert(parcel);
        return true;
    }

    @PostMapping("update")
    public boolean update(Parcel parcel){
        parcelService.update(parcel);
        return true;
    }

    @PostMapping("delete")
    public boolean delete(String id){
        String[] split = id.split(",");
        for (int i = 0; i < split.length; i++) {
            boolean delete = parcelService.deleteById(Integer.parseInt(split[i]));
            System.out.println("delete = " + delete);
        }
      return true;
    }

    @GetMapping("selectOAS")
    public Map<String,Object> selectOrders(){
        Map<String,Object> map=new HashMap<>();
        map.put("station",stationService.queryAll(null));
        map.put("orders",ordersService.queryAll(null));
        return map;
    }

}
