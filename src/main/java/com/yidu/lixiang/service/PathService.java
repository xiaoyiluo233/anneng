package com.yidu.lixiang.service;

import com.yidu.entity.Path;

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
    public String[] queryStation(String cityName);

    /**
     * 查询所有
     * @param path 线路实体类
     * @return 线路集合
     */
    HashMap<String,Object> queryAll(Path path);

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
     * 新增数据
     *
     * @param path 实例对象
     * @return 实例对象
     */
    Path insert(Path path);

    /**
     * 修改数据
     *
     * @param path 实例对象
     * @return 实例对象
     */
    Path update(Path path);

    /**
     * 通过主键删除数据
     *
     * @param pathid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pathid);

}