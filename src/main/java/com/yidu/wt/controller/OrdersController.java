package com.yidu.wt.controller;

import com.yidu.entity.Orders;
import com.yidu.wt.service.OrdersService;
import com.yidu.wt.util.BarCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
    @Autowired
    private OrdersService ordersService;
    /**
     * 查询所有
     * @return 订单集合
     */
    @ResponseBody
    @RequestMapping("orders_selectAll")
    public List<Orders> selectAll(){
        //返回订单集合
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
        //返回订单集合
        return  ordersService.queryAllByLimit(offset,limit,pvalue);
    }

    /**
     * 新增订单
     * @param orders 订单对象
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping("orders_insert")
    public String insert(Orders orders,HttpServletRequest request){
        //得到当前项目地址
        String path=request.getServletContext().getRealPath("/");
        //在当前项目下创建文件夹
        File filePath = new File(path + "/myFile");
        //判断指定地址是否存在
        if(!filePath.exists()){
            //不存在则创建
            filePath.mkdir();
            System.out.println("创建文件夹地址:"+filePath.getAbsolutePath());
        }
        //创建日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        //创建图片名
        String imgname = df.format(new Date()) + ".png";
        //创建随机数
        Random random=new Random();
        //生成10000000到999999999之间的随机数
        int ran = random.nextInt(899999999) + 10000000;
        //随机数加上s生成条码内容
        String txm=ran+"s";
        //调用条码生成工具类放入条码内容与地址生成条码
        BarCodeUtils.getBarCode(txm,filePath+"\\"+imgname);
        //在数据库生成条码名字
        orders.setBarcode(imgname);
        //调用新增的方法
        String insert = ordersService.insert(orders);
        //返回结果
        return insert;
    }

    /**
     * 修改订单
     * @param orders 订单对象
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping("orders_update")
    public String update(Orders orders){
        //调用修改的方法
        String update = ordersService.update(orders);
        //返回结果
        return update;
    }

    /**
     * 删除订单
     * @param oids 主键
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping("orders_delete")
    public String delete(String oids){
        //调用删除的方法
        String deleteById = ordersService.deleteById(oids);
        //返回结果
        return deleteById;
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ResponseBody
    @GetMapping("orders_selectOne")
    public Orders selectOne(Integer id) {
        //返回根据id查询到的数据
        return this.ordersService.queryById(id);
    }

}