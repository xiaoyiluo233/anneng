package com.yidu.ljj.dao;

import com.yidu.entity.Producttype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Producttype)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-29 15:19:20
 */
@Repository
@Mapper
public interface ProducttypeDao {

    /**
     * 根据模糊查询条件统计行数
     *
     * @param text 搜索条件
     * @return 总行数
     */
    int count(String text);

    /**
     * 通过ID查询单条数据
     *
     * @param  ptid 主键
     * @return 实例对象
     */
    Producttype queryById(int ptid );

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Producttype> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("text") String text);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param producttype 实例对象
     * @return 对象列表
     */
    List<Producttype> queryAll(Producttype producttype);

    /**
     * 新增数据
     *
     * @param producttype 实例对象
     * @return 影响行数
     */
    int insert(Producttype producttype);

    /**
     * 修改数据
     *
     * @param producttype 实例对象
     * @return 影响行数
     */
    int update(Producttype producttype);

    /**
     * 通过主键删除数据
     *
     * @param ptid 主键
     * @return 影响行数
     */
    int deleteById(int ptid);

}