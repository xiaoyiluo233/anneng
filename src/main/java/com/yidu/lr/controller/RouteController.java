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
 * (Route)表控制层
 *
 * @author makejava
 * @since 2021-01-11 16:23:49
 */
@RestController
@RequestMapping("route")
public class RouteController {
    /**
     * 服务对象
     */
    @Resource
    private RouteService routeService;

    @Resource
    private StationService stationService;
    /**
     * 通过实体作为筛选条件查询
     * @return 对象列表
     */
    @GetMapping("selectAll")
    public List<RouteTrucksPathVo> selectAll() {
        return routeService.selectAll();
    }

    /**
     * 通过实体作为筛选条件查询
     * @return 对象列表
     */
    @GetMapping("selectByIdStation")
    public List<Station> selectByIdStation(String id) {
        String[] split = id.split("-");
        return stationService.queryByArray(split);
    }

    @PostMapping("delete")
    public boolean delete(String id){
        String[] split = id.split(",");
        for (int i = 0; i < split.length; i++) {
            boolean delete = routeService.deleteById(Integer.parseInt(split[i]));
        }
        return true;
    }


}