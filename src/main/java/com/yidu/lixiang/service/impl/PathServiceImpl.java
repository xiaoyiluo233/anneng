package com.yidu.lixiang.service.impl;

import com.yidu.entity.Path;
import com.yidu.entity.Station;
import com.yidu.entity.StationMain;
import com.yidu.lixiang.dao.PathDao;
import com.yidu.lixiang.dao.StationDao;
import com.yidu.lixiang.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public HashMap<String, Object> queryAll(Path path) {
        //申明返回的map集合
        HashMap<String,Object> resultMap=new HashMap<>();
        //申明数组用于存储实体类
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
        resultMap.put("rows",list);
        resultMap.put("total",pathDao.count());
        return resultMap;
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
     * 新增数据
     *
     * @param path 实例对象
     * @return 实例对象
     */
    @Override
    public Path insert(Path path) {
        this.pathDao.insert(path);
        return path;
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
     *
     * @param pathid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pathid) {
        return this.pathDao.deleteById(pathid) > 0;
    }
}