package com.yidu.ly.controller;

import com.yidu.entity.Warehouse;
import com.yidu.ly.service.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * (Warehouse)表控制层
 * @author makejava
 * @since 2020-12-31 13:53:30
 */
@Controller
public class WarehouseController {

    @Autowired
    private WarehouseServiceImpl warehouseService;

    @ResponseBody
    @RequestMapping(value = "warehouse-selectAll",produces = {("application/json;charset=utf-8")})
    public HashMap<String,Object> selectAll(Integer offset, Integer pageNumber, String name){
        return warehouseService.queryAllByLimit(offset, pageNumber, name);
    }

    @ResponseBody
    @RequestMapping(value = "warehouse-update",produces = {("application/json;charset=utf-8")})
    public String update(Warehouse warehouse){
        return warehouseService.update(warehouse);
    }

    @ResponseBody
    @RequestMapping(value = "warehouse-delete",produces = {("application/json;charset=utf-8")})
    public String delete(String id){
        String [] split=id.split(",");
        for (int i = 0; i < split.length; i++) {
            int wid=Integer.parseInt(split[i]);
            warehouseService.deleteById(wid);
        }
        return "删除成功";
    }

    @ResponseBody
    @RequestMapping(value = "warehouse-insert",produces = {("application/json;charset=utf-8")})
    public String insert(Warehouse warehouse){
        return warehouseService.insert(warehouse);
    }

    @ResponseBody
    @RequestMapping("warehouse-selectOne")
    public Warehouse selectOne(Integer id) {
        return warehouseService.queryById(id);
    }

}