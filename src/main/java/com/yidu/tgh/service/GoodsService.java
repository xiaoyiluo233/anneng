package com.yidu.tgh.service;

import com.yidu.entity.Goods;
import com.yidu.entity.Trucks;

import java.util.HashMap;
import java.util.List;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2021-01-05 16:25:15
 */
public interface GoodsService {

    int[] getWids();

    String [] getWnames();

    /**
     * 查询所有物流信息
     * @param goods
     * @return
     */
    List<Goods> selects(Goods goods);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods inserts(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods updates(Goods goods);


    List<HashMap<String,Object>>getNames();

    /**
     * 查询所有物流跟踪
     * @param goods 物流跟踪实体
     * @return 物流跟踪集合
     */
    HashMap<String,Object>queryAll(Goods goods);

    /**
     * 通过ID查询单条数据
     *
     * @param taid 主键
     * @return 实例对象
     */
    Goods queryById(Integer taid);

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
     * @param goods 实例对象
     * @return 实例对象
     */
    String insert(Goods goods);

    /**
     *
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    String update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param taid 主键
     * @return
     */
    String deleteById(String taid);



}