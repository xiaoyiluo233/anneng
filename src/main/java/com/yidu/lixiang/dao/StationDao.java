package com.yidu.lixiang.dao;

import com.yidu.entity.Station;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Station)表数据库访问层
 *
 * @author lixiang
 * @since 2020-12-28 14:59:58
 */
@Repository
@Mapper
public interface StationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param stationid 主键
     * @return 实例对象
     */
    Station queryById(Integer stationid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Station> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param station 实例对象
     * @return 对象列表
     */
    List<Station> queryAll(Station station);

    /**
     * 新增数据
     *
     * @param station 实例对象
     * @return 影响行数
     */
    int insert(Station station);

    /**
     * 修改数据
     *
     * @param station 实例对象
     * @return 影响行数
     */
    int update(Station station);

    /**
     * 通过主键删除数据
     *
     * @param stationid 主键
     * @return 影响行数
     */
    int deleteById(Integer stationid);

}