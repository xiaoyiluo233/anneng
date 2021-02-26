package com.yidu.zsh.controller;


import com.yidu.entity.Product;
import com.yidu.zsh.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Product)表控制层
 *
 * @author makejava
 * @since 2021-01-05 15:47:47
 */
@Controller
public class ProductController {
    /**
     * 服务对象
     */
    @Autowired
    private ProductServiceImpl productService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ResponseBody
    @RequestMapping("product_selectOne")
    public Product selectOne(Integer id) {
        return this.productService.queryById(id);
    }

    /**
     *
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping("product_queryAll")
    public List<Product> queryAll(Product product){
        return productService.queryAll(product);
    }

    /**
     *  新增数据
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "product_insert",produces = {("application/json;charset=utf-8")})
    public String insert(Product product){
        product.setUid(1);
        product.setPtid(1);
        product.setPwid(1);
        product.setMyaid(1);
        product.setYouaid(1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        product.setTimes(df.format(new Date()));//得到当前时间
        product.setWeight(30.5);
        String insert = productService.insert(product);
        return insert;
    }

    /**
     *  修改数据
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "product_update",produces = {("application/json;charset=utf-8")})
    public String update(Product product){
        String update = productService.update(product);
        return update;
    }

    /**
     *
     * @param pid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "product_delete",produces = {("application/json;charset=utf-8")})
    public String deleteById(String pid){
        String deleteById = productService.deleteById(pid);
        return deleteById;
    }

}