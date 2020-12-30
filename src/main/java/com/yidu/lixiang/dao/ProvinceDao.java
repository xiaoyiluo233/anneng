package com.yidu.lixiang.dao;

import com.yidu.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 省级表持久层
 * @author: lixiang
 * @date: 2020/12/30 15:11
 * @version 1.0
 */
@Repository
@Mapper
public interface ProvinceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param provinceid 主键
     * @return 实例对象
     */
    Province queryById(Integer provinceid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Province> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param province 实例对象
     * @return 对象列表
     */
    List<Province> queryAll(Province province);

    /**
     * 新增数据
     *
     * @param province 实例对象
     * @return 影响行数
     */
    int insert(Province province);

    /**
     * 修改数据
     *
     * @param province 实例对象
     * @return 影响行数
     */
    int update(Province province);

    /**
     * 通过主键删除数据
     *
     * @param provinceid 主键
     * @return 影响行数
     */
    int deleteById(Integer provinceid);

}