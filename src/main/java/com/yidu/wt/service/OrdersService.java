package com.yidu.wt.service;

import com.yidu.entity.Orders;

import java.util.HashMap;
import java.util.List;

/**
 * (Orders)表服务接口
 *
 * @author makejava
 * @since 2021-01-06 08:36:00
 */
public interface OrdersService {
    /**
     * 连表查询所有
     * @return 相连表所有数据
     */
    List<Orders> selectAll();
    /**
     * 通过ID查询单条数据
     *
     * @param oid 主键
     * @return 实例对象
     */
    Orders queryById(Integer oid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @param pvalue 货品详情
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(int offset, int limit,String pvalue);

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    String insert(Orders orders);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    String update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param oids 主键
     * @return 是否成功
     */
    String deleteById(String oids);

}