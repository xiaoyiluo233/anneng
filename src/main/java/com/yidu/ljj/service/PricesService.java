package com.yidu.ljj.service;

import com.yidu.entity.Prices;

import java.util.HashMap;
import java.util.List;

/**
 * (Prices)表服务接口
 *
 * @author makejava
 * @since 2021-01-08 16:27:06
 */
public interface PricesService {

    /**
     * 通过ID查询单条数据
     *
     * @param priceid 主键
     * @return 实例对象
     */
    Prices queryById( Integer priceid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(int offset, int limit,String text);

    /**
     * 新增数据
     *
     * @param prices 实例对象
     * @return 实例对象
     */
    String insert(Prices prices);

    /**
     * 修改数据
     *
     * @param prices 实例对象
     * @return 实例对象
     */
    String update(Prices prices);

    /**
     * 通过主键删除数据
     *
     * @param priceid 主键
     * @return 是否成功
     */
    String deleteById(Integer priceid);

}