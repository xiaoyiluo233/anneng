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
     * 根据员工id删除数据
     * @param eid 员工id
     * @return 是否成功
     */
    String deleteEid(Integer eid);

    /**
     * 修改数据
     *
     * @param eid 员工id
     * @return 影响行数
     */
    String updateEid(Integer eid);

    /**
     * 修改数据
     *
     * @param type 操作类型
     * @return 影响行数
     */
    String updateType(Integer type);

    /**
     * 根据操作类型删除
     * @param type 操作类型
     * @return 是否成功
     */
    String deleteType(Integer type);

    /**
     * 根据操作类型删除
     * @param times 操作时间
     * @return 影响行数
     */
    String deleteTimes(Integer times);

    /**
     * 根据操作类型删除
     * @param message 操作信息
     * @return 影响行数
     */
    String deleteMessage(Integer message);

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