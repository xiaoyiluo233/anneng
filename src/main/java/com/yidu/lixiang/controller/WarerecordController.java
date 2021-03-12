package com.yidu.lixiang.controller;

import com.yidu.entity.Warerecord;
import com.yidu.lixiang.service.WarerecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * @description: 仓库记录表控制层
 * @author: lixiang
 * @date: 2021/3/11 18:30
 * @version 1.0
 */
@Controller
public class WarerecordController {
    /**
     * 服务对象
     */
    @Autowired
    private WarerecordService warerecordService;

    /**
     * 连表查询出员工名、仓库名以及仓库记录表的基本数据
     * @return 数据集合
     */
    @RequestMapping("wareRecord_getMainData")
    @ResponseBody
    public List<HashMap<String,Object>> getMainData(){
        return warerecordService.getMainData();
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("wareRecord_selectOne")
    @ResponseBody
    public Warerecord selectOne(Integer id) {
        return this.warerecordService.queryById(id);
    }

}