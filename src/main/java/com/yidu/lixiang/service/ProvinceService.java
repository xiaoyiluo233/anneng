package com.yidu.lixiang.service;

import com.yidu.entity.Province;
import java.util.List;

/**
 * @description: 省级表业务层
 * @author: lixiang
 * @date: 2020/12/30 15:11
 * @version 1.0
 */
public interface ProvinceService {

    /**
     * 通过ID查询单条数据
     *
     * @param provinceid 主键
     * @return 实例对象
     */
    Province queryById(Integer provinceid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Province> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param province 实例对象
     * @return 实例对象
     */
    Province insert(Province province);

    /**
     * 修改数据
     *
     * @param province 实例对象
     * @return 实例对象
     */
    Province update(Province province);

    /**
     * 通过主键删除数据
     *
     * @param provinceid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer provinceid);

}