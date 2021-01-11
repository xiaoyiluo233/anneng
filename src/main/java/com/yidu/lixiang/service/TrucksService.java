package com.yidu.lixiang.service;

import com.yidu.entity.Employee;
import com.yidu.entity.Trucks;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 车辆表业务层
 * @author: lixiang
 * @date: 2020-12-29 10:32:52
 * @version 1.0
 */
public interface TrucksService {
    /**
     * 查出所有的车牌号
     * @return 车牌号数组
     */
    String[] getTnumber();

    /**
     * 根据角色id查出员工id
     * @param roleid 角色id
     * @return 员工id数组
     */
    int[] getEidByRoleId(int roleid);
    /**
     * 根据角色id查出员工姓名
     * @param roleid 角色id
     * @return 员工姓名数组
     */
    String[] getEnameByRoleId(int roleid);

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