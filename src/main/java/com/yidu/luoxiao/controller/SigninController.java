package com.yidu.luoxiao.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yidu.entity.Signin;
import com.yidu.luoxiao.service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Signin)表控制层
 *
 * @author makejava
 * @since 2021-01-06 11:00:33
 */
@Controller
public class SigninController {
    /**
     * 服务对象
     */
    @Autowired
    private SigninService signinService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("signin_queryAllByLimit")
    @ResponseBody
    public List<Signin> queryAll(){
        return signinService.queryAll();
    }

    /**
     * 修改
     * @param signin
     * @return
     */
    @RequestMapping("signin_update")
    @ResponseBody
    public Boolean update(Signin signin){
       Boolean update= signinService.update(signin);
       return update;
    }

    /**
     * 新增
     * @param signin
     * @return
     */
    @RequestMapping("signin_insert")
    @ResponseBody
    public Boolean insert(Signin signin){
        Boolean insert=signinService.insert(signin);
        return insert;
    }

    /**
     * 删除
     * @param signid
     * @return
     */
    @RequestMapping("signin_delete")
    @ResponseBody
    public Boolean delete(Integer signid){
        Boolean delete=signinService.deleteById(signid);
        return  delete;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("signin_selectOne")
    public Signin selectOne(Integer id) {
        return this.signinService.queryById(id);
    }

}