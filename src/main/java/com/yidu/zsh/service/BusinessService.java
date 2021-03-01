package com.yidu.zsh.service;

import com.yidu.entity.Business;

import java.util.List;

/**
 * (Business)表服务接口
 *
 * @author makejava
 * @since 2021-01-08 14:25:29
 */
public interface  BusinessService {

    /**
     * 通过ID查询单条数据
     *
     * @param bid 主键
     * @return 实例对象
     */
    Business queryById(Integer bid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Business> queryAllByLimit(int offset, int limit);

    /**
     * 查询所有
     * @param business
     * @return
     */
    List<Business> queryAll(Business business);

    /**
     * 新增数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    String insert(Business business);

    /**
     * 修改数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    String update(Business business);

    /**
     * 通过主键删除数据
     *
     * @param bid 主键
     * @return 是否成功
     */
    String deleteById(String bid);

}