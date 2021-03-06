package com.yidu.lixiang.service;

import com.yidu.entity.Path;
import com.yidu.entity.StationMain;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 线路表业务层
 * @author: lixiang
 * @date: 2020/12/31 11:04
 * @version 1.0
 */
public interface PathService {
    /**
     * 查询出中转站
     * @param cityName 市级名
     * @return 中转站数组
     */
    String[] queryStation(String cityName);

    /**
     * 查询所有
     * @return 实体类
     */
    List<StationMain> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param pathid 主键
     * @return 实例对象
     */
    Path queryById(Integer pathid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Path> queryAllByLimit(int offset, int limit);

    /**
     * 新增线路
     * @param startStation 起点站
     * @param destinationName 经过的中转站
     * @param stationCenters 终点站
     * @return 新增成功
     */
    String insert(String startStation,String destinationName,String stationCenters);

    /**
     * 修改数据
     *
     * @param path 实例对象
     * @return 实例对象
     */
    Path update(Path path);

    /**
     * 通过主键删除数据
     * @param ids 主键字符串
     * @return 删除成功
     */
    String deleteById(String ids);

}