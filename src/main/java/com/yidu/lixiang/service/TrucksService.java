package com.yidu.lixiang.service;

import com.yidu.entity.Trucks;

import java.util.HashMap;
import java.util.List;

/**
 * (Trucks)表服务接口
 *
 * @author lixiang
 * @since 2020-12-29 10:32:52
 */
public interface TrucksService {

    /**
     * 查询所有货车
     * @param trucks 货车实体
     * @return 货车集合
     */
    HashMap<String,Object> queryAll(Trucks trucks);

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    Trucks queryById(Integer tid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param trucks 货车实体
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(Integer offset, Integer limit, String tnumbers);

    /**
     * 新增数据
     *
     * @param trucks 实例对象
     * @return 实例对象
     */
    String insert(Trucks trucks);

    /**
     * 修改数据
     *
     * @param trucks 实例对象
     * @return 实例对象
     */
    String update(Trucks trucks);

    /**
     * 通过主键删除数据
     *
     * @param tids 主键
     * @return 是否成功
     */
    String deleteById(String tids);

}