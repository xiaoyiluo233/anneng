package com.yidu.lr.service.impl;

import com.yidu.entity.City;
import com.yidu.lr.dao.LRCityDao;
import com.yidu.lr.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (City)表服务实现类
 *
 * @author makejava
 * @since 2021-01-08 18:07:33
 */
@Service
public class LRCityServiceImpl implements CityService {
    @Autowired
    private LRCityDao cityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cityid 主键
     * @return 实例对象
     */
    @Override
    public City queryById(Integer cityid) {
        return this.cityDao.queryById(cityid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<City> queryAllByLimit(int offset, int limit) {
        return this.cityDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param city 实例对象
     * @return 实例对象
     */
    @Override
    public City insert(City city) {
        this.cityDao.insert(city);
        return city;
    }

    /**
     * 修改数据
     *
     * @param city 实例对象
     * @return 实例对象
     */
    @Override
    public City update(City city) {
        this.cityDao.update(city);
        return this.queryById(city.getCityid());
    }

    /**
     * 通过主键删除数据
     *
     * @param cityid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cityid) {
        return this.cityDao.deleteById(cityid) > 0;
    }

    @Override
    public List<City> queryByProvinId(Integer provinid) {
        return cityDao.queryByProvinceId(provinid);
    }
}