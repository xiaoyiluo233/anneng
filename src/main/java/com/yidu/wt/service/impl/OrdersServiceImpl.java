package com.yidu.wt.service.impl;

import com.yidu.wt.dao.OrdersDao;
import com.yidu.entity.Orders;
import com.yidu.wt.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Orders)表服务实现类
 *
 * @author makejava
 * @since 2021-01-06 08:36:01
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;

    @Override
    public List<Orders> selectAll() {
        return ordersDao.selectAll();

    }

    /**
     * 通过ID查询单条数据
     *
     * @param oid 主键
     * @return 实例对象
     */
    @Override
    public Orders queryById(Integer oid) {
        return this.ordersDao.queryById(oid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param pvalue 货品详情
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(int offset, int limit,String pvalue) {
        //创建map集合
        HashMap<String,Object> map=new HashMap<>();
        //添加行数据
        map.put("rows",ordersDao.queryAllByLimit(offset,limit,pvalue));
        //添加总行数
        map.put("total",ordersDao.count());
        //返回map集合
        return map;
    }

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Orders orders) {
        //申明变量用于返回值
        String result="添加失败！";
        //设置订单状态
        orders.setConditions(1);
        //设置运输方式
        orders.setShipping(1);
        //新增订单
        int insert = this.ordersDao.insert(orders);
        //判断是否新增成功
        if(insert>0){
            result="添加成功！";
        }
        //返回结果
        return result;
    }

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Orders orders) {
        //申明变量用于返回值
        String result="修改失败！";
        //新增车辆
        int update = this.ordersDao.update(orders);
        //判断是否新增成功
        if (update>0){
            result="修改成功！";
        }
        //返回结果
        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param oids 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(String oids) {
        //申明变量用于返回值
        int result=0;
        //根据,截取id
        String[] split = oids.split(",");
        //循环出所有的id
        for (int i = 0; i < split.length; i++) {
            //调用删除的方法
            int deleteById = ordersDao.deleteById(Integer.parseInt(split[i]));
            if (deleteById>0){
                result++;
            }
        }
        //判断是否删除成功
        if (result==split.length){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }
}