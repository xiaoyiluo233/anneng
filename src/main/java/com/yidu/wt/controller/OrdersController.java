package com.yidu.wt.controller;

import com.yidu.entity.Orders;
import com.yidu.wt.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2021-01-06 08:36:01
 */
@Controller
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;

    /**
     * 查询所有
     * @return 订单集合
     */
    @ResponseBody
    @RequestMapping("orders_selectAll")
    public List<Orders> selectAll(){

        return  ordersService.selectAll();
    }

    /**
     * 分页模糊查询
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param pvalue 货品详情
     * @return 订单集合
     */
    @ResponseBody
    @RequestMapping("orders_selectLimit")
    public HashMap<String,Object> selectLimit(int offset, int limit,String pvalue){
        return  ordersService.queryAllByLimit(offset,limit,pvalue);
    }
    @ResponseBody
    @RequestMapping("orders_insert")
    public String insert(Orders orders){
        //调用新增的方法
        String insert = ordersService.insert(orders);
        return insert;
    }
    @ResponseBody
    @RequestMapping("orders_update")
    public String update(Orders orders){
        //调用修改的方法
        String update = ordersService.update(orders);
        return update;
    }
    @ResponseBody
    @RequestMapping("orders_delete")
    public String delete(String oids){
        //调用删除的方法
        String deleteById = ordersService.deleteById(oids);
        return deleteById;
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Orders selectOne(Integer id) {
        return this.ordersService.queryById(id);
    }

}