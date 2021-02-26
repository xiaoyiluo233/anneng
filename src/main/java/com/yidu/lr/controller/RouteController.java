package com.yidu.lr.controller;

import com.yidu.entity.Route;
import com.yidu.entity.Station;
import com.yidu.lr.controller.vo.RouteTrucksPathVo;
import com.yidu.lr.service.RouteService;
import com.yidu.lr.service.StationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.List;

/**
 * 路由表控制层
 *
 * @author lr
 * @since 2021-01-11 16:23:49
 */
@RestController
@RequestMapping("route")
public class RouteController {
    //路由服务对象
    @Resource
    private RouteService routeService;
    //中转站服务对象
    @Resource
    private StationService stationService;

    /**
     * 连表查询所有路由信息
     * @return 对象列表
     */
    @GetMapping("selectAll")
    public List<RouteTrucksPathVo> selectAll() {
        return routeService.selectAll();
    }

    /**
     * 通过id数组作为筛选条件查询
     * @return 对象列表
     */
    @GetMapping("selectByIdStation")
    public List<Station> selectByIdStation(String id) {
        //截取id
        String[] split = id.split("-");
        //根据数组查询并返回
        return stationService.queryByArray(split);
    }

    /**
     * 根据id删除
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    public boolean delete(String id){
        //截取id字符串
        String[] split = id.split(",");
        //循环id数组
        for (int i = 0; i < split.length; i++) {
            //根据id删除
            boolean delete = routeService.deleteById(Integer.parseInt(split[i]));
        }
        //返回信息
        return true;
    }


}