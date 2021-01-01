package com.yidu.ljj.service;

import com.yidu.entity.Producttype;

import java.util.HashMap;
import java.util.List;

/**
 * (Producttype)表服务接口
 *
 * @author makejava
 * @since 2020-12-29 15:19:21
 */
public interface ProducttypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param ptid 主键
     * @return 实例对象
     */
    Producttype queryById(int ptid);

    List<Producttype> queryAll(Producttype producttype);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(int offset, int limit,String text);

    /**
     * 新增数据
     *
     * @param producttype 实例对象
     * @return 实例对象
     */
    String insert(Producttype producttype);

    /**
     * 修改数据
     *
     * @param producttype 实例对象
     * @return 实例对象
     */
    String update(Producttype producttype);

    /**
     * 通过主键删除数据
     *
     * @param ptid 主键
     * @return 是否成功
     */
    String deleteById(int ptid);

}