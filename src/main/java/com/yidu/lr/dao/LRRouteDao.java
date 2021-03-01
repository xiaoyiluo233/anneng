package com.yidu.lr.dao;

import com.yidu.entity.Route;
import com.yidu.lr.controller.vo.RouteTrucksPathVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Route)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-11 16:23:49
 */
@Repository
@Mapper
public interface LRRouteDao {


    /**
     * 查询所有
     * @return
     */
    List<RouteTrucksPathVo> selectAll();
    /**
     * 通过ID查询单条数据
     *
     * @param routeid 主键
     * @return 实例对象
     */
    Route queryById(Integer routeid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Route> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param route 实例对象
     * @return 对象列表
     */
    List<Route> queryAll(Route route);

    /**
     * 新增数据
     *
     * @param route 实例对象
     * @return 影响行数
     */
    int insert(Route route);

    /**
     * 修改数据
     *
     * @param route 实例对象
     * @return 影响行数
     */
    int update(Route route);

    /**
     * 通过主键删除数据
     *
     * @param routeid 主键
     * @return 影响行数
     */
    int deleteById(Integer routeid);

}