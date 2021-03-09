package com.yidu.lixiang.controller;

import com.yidu.entity.Province;
import com.yidu.lixiang.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: 省级表控制层
 * @author: lixiang
 * @date: 2020/12/30 15:10
 * @version 1.0
 */
@Controller
public class ProvinceController {
    /**
     * 服务对象
     */
    @Autowired
    private ProvinceService provinceService;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("province_selectOne")
    @ResponseBody
    public Province selectOne(Integer id) {
        return this.provinceService.queryById(id);
    }

}