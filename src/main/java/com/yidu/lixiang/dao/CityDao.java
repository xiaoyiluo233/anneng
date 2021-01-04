package com.yidu.lixiang.dao;

import com.yidu.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 市级表持久层
 * @author: lixiang
 * @date: 2020/12/30 15:16
 * @version 1.0
 */
@Repository
@Mapper
public interface CityDao {

    /**
     * 根据城市名查出城市id
     * @param cityname 城市名
     * @return 城市id
     */
    int getCityIdByCityName(String cityname);

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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<City> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param city 实例对象
     * @return 对象列表
     */
    List<City> queryAll(City city);

    /**
     * 新增数据
     *
     * @param city 实例对象
     * @return 影响行数
     */
    int insert(City city);

    /**
     * 修改数据
     *
     * @param city 实例对象
     * @return 影响行数
     */
    int update(City city);

    /**
     * 通过主键删除数据
     *
     * @param cityid 主键
     * @return 影响行数
     */
    int deleteById(Integer cityid);

}