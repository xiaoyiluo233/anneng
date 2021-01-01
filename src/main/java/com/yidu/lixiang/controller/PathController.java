package com.yidu.lixiang.controller;

import com.yidu.entity.Path;
import com.yidu.lixiang.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @description: 线路表控制层
 * @author: lixiang
 * @date: 2020/12/31 11:05
 * @version 1.0
 */
@Controller
public class PathController {
    /**
     * 服务对象
     */
    @Autowired
    private PathService pathService;

    @ResponseBody
    @RequestMapping("path_queryAll")
    public HashMap<String,Object> queryAll(Path path){
        return pathService.queryAll(path);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("path_selectOne")
    @ResponseBody
    public Path selectOne(Integer id) {
        return this.pathService.queryById(id);
    }

}