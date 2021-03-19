package com.yidu.tgh.dao;

import com.yidu.entity.Trucksstation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author 谭光辉
 * @version 1.0
 * @公司 一度教育
 * @since 2021-01-11 09:02:03
 */
@Repository
@Mapper
public interface TrucksstationDao {

    /**
     * 将得到的名字存入集合
     * @return 实例对象
     */

    List<HashMap<String,Object>> getName();

    /**
     * 统计行数
     *
     * @param
     * @return 实例对象
     */
    int count (String tnumbers);

    /**
     * 通过ID查询单条数据
     *
     * @param tsid 主键
     * @return 实例对象
     */
    Trucksstation queryById(Integer tsid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Trucksstation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("tnumbers")String tnumbers);



    /**
     * 通过实体作为筛选条件查询
     *
     * @param trucksstation 实例对象
     * @return 对象列表
     */
    List<Trucksstation> queryAll(Trucksstation trucksstation);

    /**
     *
     * 新增数据
     *
     * @param trucksstation 实例对象
     * @return 影响行数
     */
    int insert(Trucksstation trucksstation);

    /**
     * 修改数据
     *
     * @param trucksstation 实例对象
     * @return 影响行数
     */
    int update(Trucksstation trucksstation);

    /**
     * 通过主键删除数据
     *
     * @param tsid 主键
     * @return 影响行数
     */
    int deleteById(Integer tsid);

}