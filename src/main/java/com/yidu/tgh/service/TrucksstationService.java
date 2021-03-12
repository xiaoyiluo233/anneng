package com.yidu.tgh.service;



import com.yidu.entity.Trucksstation;

import java.util.HashMap;
import java.util.List;

/**
 * (Trucksstation)表服务接口
 *
 * @author makejava
 * @since 2021-01-11 09:02:03
 */
public interface TrucksstationService {

    List<HashMap<String,Object>> getName();
    /**
     *
     * 查询所有货车到站
     * @param trucksstation 物流跟踪实体
     * @return 物流跟踪集合
     */
    HashMap<String,Object>queryAll(Trucksstation trucksstation);

    /**
     * 通过ID查询单条数据
     *
     * @param tsid 主键
     * @return 实例对象
     */
    Trucksstation queryById(Integer tsid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(Integer offset, Integer limit,String tnumbers);
    /**
     * 新增数据
     *
     * @param trucksstation 实例对象
     * @return 实例对象
     */
    String insert(Trucksstation trucksstation);

    /**
     * 修改数据
     *
     * @param trucksstation 实例对象
     * @return 实例对象
     */
    String update(Trucksstation trucksstation);

    /**
     * 通过主键删除数据
     *
     * @param tsid 主键
     * @return 是否成功
     */
    String deleteById(String tsid);

}