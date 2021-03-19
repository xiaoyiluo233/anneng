package com.yidu.lr.service.impl;

import com.yidu.entity.Path;
import com.yidu.entity.Route;
import com.yidu.lr.controller.vo.RouteTrucksPathVo;
import com.yidu.lr.dao.LRRouteDao;
import com.yidu.lr.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Route)表服务实现类
 *
 * @author makejava
 * @since 2021-01-11 16:23:49
 */
@Service("routeService")
public class LRRouteServiceImpl implements RouteService {
    @Autowired
    private LRRouteDao routeDao;

    @Override
    public List<RouteTrucksPathVo> selectAll() {
        return routeDao.selectAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param routeid 主键
     * @return 实例对象
     */
    @Override
    public Route queryById(Integer routeid) {
        return this.routeDao.queryById(routeid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Route> queryAllByLimit(int offset, int limit) {
        return this.routeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param route 实例对象
     * @return 实例对象
     */
    @Override
    public Route insert(Route route) {
        this.routeDao.insert(route);
        return route;
    }

    /**
     * 修改数据
     *
     * @param route 实例对象
     * @return 实例对象
     */
    @Override
    public Route update(Route route) {
        this.routeDao.update(route);
        return this.queryById(route.getRouteid());
    }

    /**
     * 通过主键删除数据
     *
     * @param routeid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer routeid) {
        return this.routeDao.deleteById(routeid) > 0;
    }

    @Override
    public List<Route> queryAll(Route route) {
        return routeDao.queryAll(route);
    }

    @Override
    public Route queryByPathId(Integer pathid) {
        return routeDao.queryByPathId(pathid);
    }

    @Override
    public Route queryAllByTid(Integer tid) {
        return routeDao.queryAllByTid(tid);
    }
}