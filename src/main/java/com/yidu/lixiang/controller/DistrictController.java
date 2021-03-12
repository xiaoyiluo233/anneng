package com.yidu.lixiang.controller;

import com.yidu.entity.District;
import com.yidu.lixiang.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 县级表控制层
 * @author: lixiang
 * @date: 2020/12/30 15:48
 * @version 1.0
 */
@Controller
public class DistrictController {
    /**
     * 服务对象
     */
    @Autowired
    private DistrictService districtService;

    /**
     * 得到区级集合
     * @return 区级集合
     */
    @ResponseBody
    @RequestMapping("district_getCity")
    public List<District> getCity(){
        return districtService.getCity(null);
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("district_selectOne")
    @ResponseBody
    public District selectOne(Integer id) {
        return this.districtService.queryById(id);
    }

}