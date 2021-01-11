package com.yidu.lixiang.controller;

import com.yidu.entity.Trucks;
import com.yidu.lixiang.service.TrucksService;
import com.yidu.lixiang.service.impl.TrucksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 车辆表控制层
 * @author: lixiang
 * @date: 2020-12-29 10:32:52
 * @version 1.0
 */
@Controller
public class TrucksController {
    /**
     * 服务对象
     */
    @Autowired
    private TrucksServiceImpl trucksService;

    @ResponseBody
    @RequestMapping("trucks_getEidsByRoleId")
    public int[] getEidsByRoleId(int roleid){
        trucksService.getTnumber();
        return trucksService.getEidByRoleId(roleid);
    }

    @ResponseBody
    @RequestMapping("trucks_getEnamesByRoleid")
    public String[] getEnamesByRoleid(int roleid){
        return trucksService.getEnameByRoleId(roleid);
    }

    @RequestMapping(value = "trucks_delete",produces = {("application/json;charset=utf-8")})
    @ResponseBody
    public String delete(String tids){
        //调用删除的方法
        String deleteById = trucksService.deleteById(tids);
        return deleteById;
    }

    @ResponseBody
    @RequestMapping(value = "trucks_update",produces = {("application/json;charset=utf-8")})
    public String update(Trucks trucks){
        //调用修改的方法
        String update = trucksService.update(trucks);
        return update;
    }

    @RequestMapping(value = "trucks_insert",produces = {("application/json;charset=utf-8")})
    @ResponseBody
    public String insert(Trucks trucks){
        //调用新增的方法
        String insert = trucksService.insert(trucks);
        return insert;
    }

    /**
     * 根据条件查询所有货车
     * @return 货车集合
     */
    @ResponseBody
    @RequestMapping("trucks_queryAll")
    public HashMap<String,Object> queryAllByLimit(Integer offset, Integer pageNumber,String tnumbers){
        return trucksService.queryAllByLimit(offset, pageNumber, tnumbers);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("trucks_selectOne")
    @ResponseBody
    public Trucks selectOne(Integer id) {
        return this.trucksService.queryById(id);
    }

}