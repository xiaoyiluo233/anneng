package com.yidu.ly.service;

import com.yidu.entity.Emplog;

import java.util.HashMap;

/**
 * (Emplog) 员工表业务层
 *
 * @author makejava
 * @since 2021-01-11 09:54:50
 */
public interface EmplogService {

    /**
     * 通过ID查询单条数据
     *
     * @param elid 主键
     * @return 实例对象
     */
    Emplog queryById(Integer elid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param name 查询值
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(int offset, int limit, Integer name);

    /**
     * 新增数据
     *
     * @param emplog 实例对象
     * @return 实例对象
     */
    String insert(Emplog emplog);

    /**
     * 修改数据
     *
     * @param emplog 实例对象
     * @return 实例对象
     */
    String update(Emplog emplog);

    /**
     * 通过主键删除数据
     *
     * @param elid 主键
     * @return 是否成功
     */
    String deleteById(Integer elid);

}