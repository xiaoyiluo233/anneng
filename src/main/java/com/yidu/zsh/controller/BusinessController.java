package com.yidu.zsh.controller;

import com.yidu.entity.Business;
import com.yidu.zsh.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Business)表控制层
 *
 * @author makejava
 * @since 2021-01-08 14:25:29
 */
@Controller
public class BusinessController {
    /**
     * 服务对象
     */
    @Autowired
    private BusinessService businessService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public Business selectOne(Integer id) {
        return this.businessService.queryById(id);
    }

    /**
     *  查询所有数据
     * @param business
     * @return
     */
    @ResponseBody
    @RequestMapping("business_queryAll")
    public List<Business> queryAll(Business business){
        return businessService.queryAll(business);
    }

    /**
     *  新增
     * @param business
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "business_insert",produces = {("application/json;charset=utf-8")})
    public String insert(Business business){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        business.setTimes(df.format(new Date()));//得到当前时间
        String insert = businessService.insert(business);
        return insert;
    }

    /**
     * 修改数据
     * @param business
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "business_update",produces = {("application/json;charset=utf-8")})
    public String update(Business business){
        String update = businessService.update(business);
        return update;
    }

    /**
     * 删除数据
     * @param bid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "business_delete",produces = {("application/json;charset=utf-8")})
    public String deleteById(String bid){
        String deleteById = businessService.deleteById(bid);
        return deleteById;
    }

}