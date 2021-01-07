package com.yidu.lixiang.service.impl;

import com.yidu.entity.Path;
import com.yidu.entity.Station;
import com.yidu.entity.StationMain;
import com.yidu.lixiang.dao.CityDao;
import com.yidu.lixiang.dao.PathDao;
import com.yidu.lixiang.dao.StationDao;
import com.yidu.lixiang.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 线路表业务实现层
 * @author: lixiang
 * @date: 2020/12/31 11:05
 * @version 1.0
 */
@Service
public class PathServiceImpl implements PathService {
    @Autowired
    private PathDao pathDao;
    @Autowired
    private StationDao stationDao;
    @Autowired
    private CityDao cityDao;
    @Autowired
    private Station station;

    @Override
    public String[] queryStation(String cityName) {
        try {
            //调用查询城市id的方法
            int cityIdByCityName = cityDao.getCityIdByCityName(cityName);
            //设置城市id
            station.setCityid(cityIdByCityName);
            //调用查询中转站的方法
            List<Station> stations = stationDao.queryAll(station);
            //申明一个数组用于存储中转站
            String[] stationName=new String[stations.size()];
            //循环取出中转站实体类
            for (int i = 0; i < stations.size(); i++) {
                //得到中转站名
                String stationname = stations.get(i).getStationname();
                //存进中转站数组中
                stationName[i]=stationname;
            }
            //返回中转站数组
            return stationName;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<StationMain> queryAll() {
        //申明集合用于存储实体类
        List<StationMain> list=new ArrayList<>();
        //创建具体的中转站实体类
        StationMain stationMain=null;
        //得到起点中转站
        List<String> startStation = pathDao.getStartStation();
        //得到终点中转站
        List<String> destination = pathDao.getDestination();
        //循环取出起/终点中转站
        for (int i = 0; i < startStation.size(); i++) {
            //申明变量用于接受经过的中转站名
            String wayStation="";
            //new一个新的实体类
            stationMain=new StationMain();
            //设置起点中转站
            stationMain.setStartStation(startStation.get(i));
            //设置终点中转站
            stationMain.setDestinationName(destination.get(i));
            //查询出所有经过的中转站的id
            List<Path> paths = pathDao.queryAll(null);
            //得到经过的中转站的id
            String stationids = paths.get(i).getStationids();
            //截取id
            String[] split = stationids.split("-");
            //循环数组
            for (int j = 0; j < split.length; j++) {
                //调用查询方法查出中转站名
                String stationname = stationDao.queryById(Integer.valueOf(split[j])).getStationname();
                //判断j+1是否是最后一个id
                if (j+1<split.length){
                    //拼接好中转站名
                    wayStation+=stationname+"-";
                }else {
                    //拼接好中转站名
                    wayStation+=stationname;
                }
            }
            //设置到实体类里
            stationMain.setStationsCenter(wayStation);
            //设置id到实体类
            stationMain.setPathId(paths.get(i).getPathid());
            //添加到集合
            list.add(stationMain);
        }
        return list;
    }


    /**
     * 通过ID查询单条数据
     *
     * @param pathid 主键
     * @return 实例对象
     */
    @Override
    public Path queryById(Integer pathid) {
        return this.pathDao.queryById(pathid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Path> queryAllByLimit(int offset, int limit) {
        return this.pathDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增线路
     * @param startStation 起点站
     * @param destinationName 经过的中转站
     * @param stationCenters 终点站
     * @return 新增成功
     */
    @Override
    public String insert(String startStation,String destinationName,String stationCenters) {
        //申明变量用于接收经过的中转站的id
        String stationIds="";
        //创建线路实体类
        Path path=new Path();
        //创建中转站实体类
        Station station=new Station();
        //1、设置起点中转站
        station.setStationname(startStation);
        //查询出起点中转站的所有信息
        List<Station> stations = stationDao.queryAll(station);
        //得到起点中转站的id
        Integer startStationId = stations.get(0).getStationid();
        //将起点站id设置进线路实体类中
        path.setStartstation(startStationId);
        //2、设置终点中转站
        station.setStationname(destinationName);
        //查询出终点中转站的所有信息
        stations=stationDao.queryAll(station);
        //得到终点中转站的id
        Integer destinationId = stations.get(0).getStationid();
        //将起点站id设置进线路实体类中
        path.setDestination(destinationId);
        //3、截取出经过的中转站
        String[] split = stationCenters.split("-");
        //循环拿出经过的中转站
        for (int i = 0; i < split.length; i++) {
            //设置经过的每一个中转站
            station.setStationname(split[i]);
            //查询出终点中转站的所有信息
            stations=stationDao.queryAll(station);
            //得到终点中转站的id
            Integer stationCenterId = stations.get(0).getStationid();
            //拼接进中转站id中
            stationIds+=stationCenterId+"-";
        }
        //将经过的中转站的id设置进线路实体类中
        path.setStationids(stationIds);
        //调用新增的方法
        int result = pathDao.insert(path);
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
     * @param path 实例对象
     * @return 实例对象
     */
    @Override
    public Path update(Path path) {
        this.pathDao.update(path);
        return this.queryById(path.getPathid());
    }

    /**
     * 通过主键删除数据
     * @param ids 主键字符串
     * @return 删除成功
     */
    @Override
    public String deleteById(String ids) {
        //申明变量用于统计删除成功的次数
        int sum=0;
        //截取出单个id
        String[] split = ids.split(",");
        //循环id数组
        for (int i = 0; i < split.length; i++) {
            //得到单个id
            int pathId = Integer.parseInt(split[i]);
            //调用删除的方法
            int deleteById = pathDao.deleteById(pathId);
            //判断是否删除成功
            if (deleteById>0){
                //成功则sum++
                sum++;
            }
        }
        //判断成功次数是否与id数组长度相同
        if (sum==split.length){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }
}