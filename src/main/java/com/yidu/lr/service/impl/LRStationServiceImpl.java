package com.yidu.lr.service.impl;

import com.yidu.entity.Station;
import com.yidu.lr.dao.LRStationDao;
import com.yidu.lr.service.StationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Station)表服务实现类
 *
 * @author makejava
 * @since 2021-01-12 14:06:28
 */
@Service("stationService")
public class LRStationServiceImpl implements StationService {
    @Resource
    private LRStationDao stationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param stationid 主键
     * @return 实例对象
     */
    @Override
    public Station queryById(Integer stationid) {
        return this.stationDao.queryById(stationid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Station> queryAllByLimit(int offset, int limit) {
        return this.stationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param station 实例对象
     * @return 实例对象
     */
    @Override
    public Station insert(Station station) {
        this.stationDao.insert(station);
        return station;
    }

    /**
     * 修改数据
     *
     * @param station 实例对象
     * @return 实例对象
     */
    @Override
    public Station update(Station station) {
        this.stationDao.update(station);
        return this.queryById(station.getStationid());
    }

    /**
     * 通过主键删除数据
     *
     * @param stationid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer stationid) {
        return this.stationDao.deleteById(stationid) > 0;
    }

    @Override
    public List<Station> queryAll(Station station) {
        return stationDao.queryAll(station);
    }

    @Override
    public List<Station> queryByArray(String[] array) {
        return stationDao.queryByArray(array);
    }
}