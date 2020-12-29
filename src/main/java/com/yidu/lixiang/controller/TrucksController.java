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
 * (Trucks)表控制层
 *
 * @author lixiang
 * @since 2020-12-29 10:32:52
 */
@Controller
public class TrucksController {
    /**
     * 服务对象
     */
    @Autowired
    private TrucksServiceImpl trucksService;

    @RequestMapping("trucks_insert")
    @ResponseBody
    public String insert(Trucks trucks){
        System.out.println("trucks = " + trucks);
        return "ok";
    }

    /**
     * 根据条件查询所有货车
     * @param trucks 货车实体
     * @return 货车集合
     */
    @ResponseBody
    @RequestMapping("trucks_queryAll")
    public HashMap<String,Object> queryAllByLimit(Integer offset, Integer pageNumber,Trucks trucks){
        return trucksService.queryAllByLimit(offset, pageNumber, trucks);
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