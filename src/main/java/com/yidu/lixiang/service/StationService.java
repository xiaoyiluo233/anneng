package com.yidu.lixiang.service;

import com.yidu.entity.City;
import com.yidu.entity.Station;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 中转站业务层
 * @author: lixiang
 * @date: 2020-12-28 14:59:59
 * @version 1.0
 */
public interface StationService {

    /**
     * 中转站与市级表的一对一关系的查询所有
     * @param city 城市实体类
     * @return 中转站集合
     */
    List<Station> stationAndCity(City city);

    /**
     * 通过ID查询单条数据
     *
     * @param stationid 主键
     * @return 实例对象
     */
    Station queryById(Integer stationid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Station> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param station 实例对象
     * @return 新增成功
     */
    String insert(Station station,String citynames);

    /**
     * 修改数据
     *
     * @param station 实例对象
     * @return 修改成功
     */
    String update(Station station,String citynames);

    /**
     * 通过主键删除数据
     *
     * @param stationids 主键
     * @return 是否成功
     */
    String deleteById(String stationids);

}