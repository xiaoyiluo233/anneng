package com.yidu.ly.dao;

import com.yidu.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Warehouse)入库表持久层
 *
 * @author makejava
 * @since 2020-12-31 13:53:28
 */
@Mapper
@Repository
public interface WarehouseDao {

    int count(String name);

    /**
     * 通过ID查询单条数据
     *
     * @param wid 主键
     * @return 实例对象
     */
    Warehouse queryById(Integer wid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param name 查询值
     * @return 对象列表
     */
    List<Warehouse> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("name") String name);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param warehouse 实例对象
     * @return 对象列表
     */
    List<Warehouse> queryAll(Warehouse warehouse);

    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 影响行数
     */
    int insert(Warehouse warehouse);

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 影响行数
     */
    int update(Warehouse warehouse);

    /**
     * 通过主键删除数据
     *
     * @param wid 主键
     * @return 影响行数
     */
    int deleteById(Integer wid);

}