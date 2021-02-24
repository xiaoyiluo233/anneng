package com.yidu.lr.service;

import com.yidu.entity.Route;
import com.yidu.lr.controller.vo.RouteTrucksPathVo;

import java.util.List;

/**
 * (Route)表服务接口
 *
 * @author makejava
 * @since 2021-01-11 16:23:49
 */
public interface RouteService {

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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Route> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param route 实例对象
     * @return 实例对象
     */
    Route insert(Route route);

    /**
     * 修改数据
     *
     * @param route 实例对象
     * @return 实例对象
     */
    Route update(Route route);

    /**
     * 通过主键删除数据
     *
     * @param routeid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer routeid);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param route 实例对象
     * @return 对象列表
     */
    List<Route> queryAll(Route route);
}