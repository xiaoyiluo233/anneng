package com.yidu.lixiang.service;

import com.yidu.entity.District;
import java.util.List;

/**
 * @description: 县级表业务层
 * @author: lixiang
 * @date: 2020/12/30 15:46
 * @version 1.0
 */
public interface DistrictService {
    /**
     * 市级与县级的一对一关系映射的查询所有
     * @param district 县级表实体类
     * @return 县级表集合
     */
    List<District> getCity(District district);

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

}