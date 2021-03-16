package com.yidu.ly.controller;

import com.yidu.entity.Emplog;
import com.yidu.ly.service.EmplogService;
import com.yidu.ly.service.impl.EmplogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * (Emplog) 日志表控制层
 *
 * @author makejava
 * @since 2021-01-11 09:54:50
 */
@Controller
public class EmplogController {

    @Autowired
    private EmplogServiceImpl emplogService;
    Integer type;

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param pageNumber 查询条数
     * @return 对象列表
     */
    @ResponseBody
    @RequestMapping(value = "emplog-selectAll",produces = {("application/json;charset=utf-8")})
    public HashMap<String,Object> selectAll(Integer offset, Integer pageNumber){
        return emplogService.queryAllByLimit(offset, pageNumber, type);
    }

    /**
     * 新增数据
     *
     * @param emplog emplog
     * @return 对象列表
     */
    @ResponseBody
    @RequestMapping(value = "emplog-insert",produces = {("application/json;charset=utf-8")})
    public String insert(Emplog emplog){
        return emplogService.insert(emplog);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @ResponseBody
    @RequestMapping(value = "emplog-delete",produces = {("application/json;charset=utf-8")})
    public String delete(String id){
        String ids[]=id.split(",");
        for (int i=0 ; i<ids.length ; i++){
            int elid=Integer.parseInt(ids[i]);
            emplogService.deleteById(elid);
        }
        return "删除成功";
    }

    /**
     * 修改数据
     *
     * @param emplog emplog
     * @return 影响行数
     */
    @ResponseBody
    @RequestMapping(value = "emplog-update",produces = {("application/json;charset=utf-8")})
    public String update(Emplog emplog){
        return emplogService.update(emplog);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ResponseBody
    @RequestMapping(value = "emplog-selectOne",produces = {("application/json;charset=utf-8")})
    public Emplog selectOne(Integer id) {
        return this.emplogService.queryById(id);
    }

    @ResponseBody
    @RequestMapping(value = "emplog-createType",produces = {("application/json;charset=utf-8")})
    public boolean createType(Integer types) {
        if(types!=0){
            type=types;
        }else{
            type=null;
        }
        return true;
    }

}