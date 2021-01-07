package com.yidu.lr.dao;

import com.yidu.entity.Parcel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Parcel)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-01 17:39:15
 */
@Mapper
public interface ParcelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param parcelid 主键
     * @return 实例对象
     */
    Parcel queryById(Integer parcelid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Parcel> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param parcel 实例对象
     * @return 对象列表
     */
    List<Parcel> queryAll(Parcel parcel);

    /**
     * 新增数据
     *
     * @param parcel 实例对象
     * @return 影响行数
     */
    int insert(Parcel parcel);

    /**
     * 修改数据
     *
     * @param parcel 实例对象
     * @return 影响行数
     */
    int update(Parcel parcel);

    /**
     * 通过主键删除数据
     *
     * @param parcelid 主键
     * @return 影响行数
     */
    int deleteById(Integer parcelid);

}