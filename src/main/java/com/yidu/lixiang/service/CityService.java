package com.yidu.lixiang.service;

import com.yidu.entity.City;
import java.util.List;

/**
 * @description: 市级业务层
 * @author: lixiang
 * @date: 2020/12/30 15:16
 * @version 1.0
 */
public interface CityService {

    /**
     * 一对一关系映射的查询所有
     * @param city 市级表实体类
     * @return 市级集合
     */
    List<City> getProvince(City city);

    /**
     * 通过ID查询单条数据
     *
     * @param cityid 主键
     * @return 实例对象
     */
    City queryById(Integer cityid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<City> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param city 实例对象
     * @return 实例对象
     */
    City insert(City city);

    /**
     * 修改数据
     *
     * @param city 实例对象
     * @return 实例对象
     */
    City update(City city);

    /**
     * 通过主键删除数据
     *
     * @param cityid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cityid);

}