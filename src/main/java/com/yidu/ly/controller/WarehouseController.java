package com.yidu.ly.controller;

import com.yidu.entity.Warehouse;
import com.yidu.ly.service.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * (Warehouse) 仓库表控制层
 * @author makejava
 * @since 2020-12-31 13:53:30
 */
@Controller
public class WarehouseController {

    @Autowired
    private WarehouseServiceImpl warehouseService;

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param pageNumber 查询条数
     * @return 对象列表
     */
    @ResponseBody
    @RequestMapping(value = "warehouse-selectAll",produces = {("application/json;charset=utf-8")})
    public HashMap<String,Object> selectAll(Integer offset, Integer pageNumber, String name){
        return warehouseService.queryAllByLimit(offset, pageNumber, name);
    }

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 影响行数
     */
    @ResponseBody
    @RequestMapping(value = "warehouse-update",produces = {("application/json;charset=utf-8")})
    public String update(Warehouse warehouse){
        return warehouseService.update(warehouse);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
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

    /**
     * 新增数据
     *
     * @param warehouse warehouse
     * @return 对象列表
     */
    @ResponseBody
    @RequestMapping(value = "warehouse-insert",produces = {("application/json;charset=utf-8")})
    public String insert(Warehouse warehouse){
        return warehouseService.insert(warehouse);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ResponseBody
    @RequestMapping(value = "warehouse-selectOne",produces = {("application/json;charset=utf-8")})
    public Warehouse selectOne(Integer id) {
        return warehouseService.queryById(id);
    }

}