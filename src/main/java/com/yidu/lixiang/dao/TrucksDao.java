package com.yidu.lixiang.dao;

import com.yidu.entity.Trucks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 车辆表持久层
 * @author: lixiang
 * @date: 2020-12-29 10:32:52
 * @version 1.0
 */
@Repository
@Mapper
public interface TrucksDao {
    /**
     * 根据条件查询总行数
     * @return 总行数
     */
    int count(String tnumbers);

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    Trucks queryById(Integer tid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Trucks> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("tnumbers")String tnumbers);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param trucks 实例对象
     * @return 对象列表
     */
    List<Trucks> queryAll(Trucks trucks);

    /**
     * 新增数据
     *
     * @param trucks 实例对象
     * @return 影响行数
     */
    int insert(Trucks trucks);

    /**
     * 修改数据
     *
     * @param trucks 实例对象
     * @return 影响行数
     */
    int update(Trucks trucks);

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 影响行数
     */
    int deleteById(Integer tid);

}