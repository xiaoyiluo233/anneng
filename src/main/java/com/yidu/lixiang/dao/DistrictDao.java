package com.yidu.lixiang.dao;

import com.yidu.entity.District;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 县级表持久层
 * @author: lixiang
 * @date: 2020/12/30 15:46
 * @version 1.0
 */
@Repository
@Mapper
public interface DistrictDao {

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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<District> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param district 实例对象
     * @return 对象列表
     */
    List<District> queryAll(District district);

    /**
     * 新增数据
     *
     * @param district 实例对象
     * @return 影响行数
     */
    int insert(District district);

    /**
     * 修改数据
     *
     * @param district 实例对象
     * @return 影响行数
     */
    int update(District district);

    /**
     * 通过主键删除数据
     *
     * @param districtid 主键
     * @return 影响行数
     */
    int deleteById(Integer districtid);

}