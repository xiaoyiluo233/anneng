package com.yidu.lixiang.dao;

import com.yidu.entity.Path;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 线路表持久层
 * @author: lixiang
 * @date: 2020/12/31 11:04
 * @version 1.0
 */
@Repository
@Mapper
public interface PathDao {
    /**
     * 得到起点中转站的名字
     * @return 起点中转站名
     */
    List<String> getStartStation();

    /**
     * 得到终点中转站的名字
     * @return 终点中转站名
     */
    List<String> getDestination();

    /**
     * 得到总行数
     * @return 总行数
     */
    int count(Path path);

    /**
     * 通过ID查询单条数据
     *
     * @param pathid 主键
     * @return 实例对象
     */
    Path queryById(Integer pathid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Path> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param path 实例对象
     * @return 对象列表
     */
    List<Path> queryAll(Path path);

    /**
     * 新增数据
     *
     * @param path 实例对象
     * @return 影响行数
     */
    int insert(Path path);

    /**
     * 修改数据
     *
     * @param path 实例对象
     * @return 影响行数
     */
    int update(Path path);

    /**
     * 通过主键删除数据
     *
     * @param pathid 主键
     * @return 影响行数
     */
    int deleteById(Integer pathid);

}