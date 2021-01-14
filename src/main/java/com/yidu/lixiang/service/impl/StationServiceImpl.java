package com.yidu.lixiang.service.impl;

import com.yidu.entity.City;
import com.yidu.entity.Station;
import com.yidu.lixiang.dao.CityDao;
import com.yidu.lixiang.dao.StationDao;
import com.yidu.lixiang.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 中转站业务接口层
 * @author: lixiang
 * @date: 2020-12-28 14:59:59
 * @version 1.0
 */
@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationDao stationDao;
    @Autowired
    private CityDao cityDao;

    @Override
    public List<Station> stationAndCity() {
        //调用查询所有的方法
        List<Station> stations = stationDao.stationAndCity();
        return stations;
    }

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
    public String insert(Station station,String citynames) {
        //创建城市实体类
        City city=new City();
        //设置城市名
        city.setCityname(citynames);
        //调用查询方法
        List<City> cities = cityDao.queryAll(city);
        //循环
        for (int i = 0; i < cities.size(); i++) {
            //得到城市id
            Integer cityid = cities.get(i).getCityid();
            station.setCityid(cityid);
        }
        //调用新增的方法
        int result = stationDao.insert(station);
        //判断是否新增成功
        if (result>0){
            return "新增成功！";
        }else {
            return "新增失败！";
        }
    }

    /**
     * 修改数据
     *
     * @param station 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Station station,String citynames) {
        //创建城市实体类
        City city=new City();
        //设置城市名
        city.setCityname(citynames);
        //调用查询方法
        List<City> cities = cityDao.queryAll(city);
        //循环
        for (int i = 0; i < cities.size(); i++) {
            //得到城市id
            Integer cityid = cities.get(i).getCityid();
            station.setCityid(cityid);
        }
        //调用修改的方法
        int result = stationDao.update(station);
        //判断是否新增成功
        if (result>0){
            return "修改成功！";
        }else {
            return "修改失败！";
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param stationids 主键
     * @return 删除成功
     */
    @Override
    public String deleteById(String stationids) {
        //申明变量用于统计成功次数
        int sum=0;
        //将id字符串切割为数组
        String[] split = stationids.split(",");
        //循环取出数组中的id
        for (int i = 0; i < split.length; i++) {
            //取出id
            int parseInt = Integer.parseInt(split[i]);
            //调用删除的方法
            int deleteById = stationDao.deleteById(parseInt);
            //判断是否删除成功
            if (deleteById>0){
                //成功则sum++
                sum++;
            }
        }
        //判断删除成功的次数是否等于数组长度
        if (sum==split.length){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }
}