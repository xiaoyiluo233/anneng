package com.yidu.tgh.controller;

import com.yidu.entity.Trucksstation;
import com.yidu.tgh.service.TrucksstationService;
import com.yidu.tgh.service.impl.TrucksstationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Controller

public class TrucksstationController {
    /**
     * 服务对象
     */
    @Autowired
    private TrucksstationServiceImpl trucksstationService;
    /**
     * 通过主键查询单条数据
     *
     * @param tsids 主键
     * @return 单条数据
     */
    @RequestMapping(value="trucksstationService_delete",produces = {("application/json;charset-utf-8")})
    @ResponseBody
    public String delete(String tsids) {
        //调用删除的方法
        String deleteById=trucksstationService.deleteById(tsids);
        return deleteById;

    }

    /**
     * 修改
     * @param trucksstation
     * @return update
     */
    @RequestMapping(value="trucksstationService_update",produces = {("application/json;charset-utf-8")})
    @ResponseBody
    public String update(Trucksstation trucksstation) {
        //调用修改的方法
        String update=trucksstationService.update(trucksstation);
        //返回修改
        return update;
    }
    @RequestMapping(value="trucksstationService_insert")
    @ResponseBody
    public String insert(Trucksstation trucksstation) {
        //System.out.println("trucksstation = " + trucksstation);
        //调用新增的方法
        String insert=trucksstationService.insert(trucksstation);
        //返回新增
        return insert;
    }
    @RequestMapping("trucksstationService_queryAll")
    @ResponseBody
    public List<HashMap<String, Object>> queryAllByLimit(Integer offset, Integer pageNumber, String tnumbers){
        //调用删除的方法
        return trucksstationService.getName();

    }

    /**
     * 查询单个
     * @param tsid
     * @return tsid
     */
    @RequestMapping("trucksstationService_selectOne")
    @ResponseBody

    public Trucksstation selectOne(Integer tsid) {
        //返回查询单个
        return this.trucksstationService.queryById(tsid);
    }

}