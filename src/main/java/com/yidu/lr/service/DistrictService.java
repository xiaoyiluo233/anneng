package com.yidu.lr.service;

import com.yidu.entity.District;

import java.util.List;

/**
 * (District)表服务接口
 *
 * @author makejava
 * @since 2021-01-08 18:05:33
 */
public interface DistrictService {

    /**
     * 通过ID查询单条数据
     *
     * @param districtid 主键
     * @return 实例对象
     */
    District queryById(Integer districtid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<District> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param district 实例对象
     * @return 实例对象
     */
    District insert(District district);

    /**
     * 修改数据
     *
     * @param district 实例对象
     * @return 实例对象
     */
    District update(District district);

    /**
     * 通过主键删除数据
     *
     * @param districtid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer districtid);

    List<District> queryByCityid(Integer cityid);
}