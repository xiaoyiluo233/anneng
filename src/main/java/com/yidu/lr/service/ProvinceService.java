package com.yidu.lr.service;

import com.yidu.entity.Province;

import java.util.List;

/**
 * (Province)表服务接口
 *
 * @author makejava
 * @since 2021-01-01 14:54:02
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