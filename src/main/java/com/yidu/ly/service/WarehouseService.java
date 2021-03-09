package com.yidu.ly.service;

import com.yidu.entity.Warehouse;

import java.util.HashMap;
import java.util.List;

/**
 * (Warehouse)入库表业务层
 *
 * @author makejava
 * @since 2020-12-31 13:53:29
 */
public interface WarehouseService {

    /**
     * 通过ID查询单条数据
     *
     * @param wid 主键
     * @return 实例对象
     */
    Warehouse queryById(Integer wid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param name 查询值
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(int offset, int limit, String name);

    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    String insert(Warehouse warehouse);

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    String update(Warehouse warehouse);

    /**
     * 通过主键删除数据
     *
     * @param wid 主键
     * @return 是否成功
     */
    String deleteById(Integer wid);

}