package com.yidu.ljj.controller;

import com.yidu.entity.Producttype;
import com.yidu.ljj.service.ProducttypeService;
import com.yidu.ljj.service.impl.ProducttypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author 刘佳佳
 * @version 1.0
 * @公司 一度教育
 * @date 2020-12-29 15:19:21
 */
@Controller
public class ProducttypeController {

    @Autowired
    ProducttypeServiceImpl producttypeService;

    @RequestMapping(value = "/producttype_delete",produces = {("application/json;charset=utf-8")})
    @ResponseBody
    public String delete(int ptid){
        return producttypeService.deleteById(ptid);
    }

    @RequestMapping(value = "/producttype_update",produces = {("application/json;charset=utf-8")})
    @ResponseBody
    public String update(Producttype produ){
        return producttypeService.update(produ);
    }

    @RequestMapping(value = "/producttype_insert",produces = {("application/json;charset=utf-8")})
    @ResponseBody
    public String insert(Producttype produ){
        return producttypeService.insert(produ);
    }

    @ResponseBody
    @RequestMapping("/producttype_selectAll")
   public HashMap<String, Object> selectAll(int offset, int pageNumber, String text){
        return producttypeService.queryAllByLimit(offset, pageNumber, text);
   }

}