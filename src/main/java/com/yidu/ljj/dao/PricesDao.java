package com.yidu.ljj.dao;

import com.yidu.entity.Prices;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Prices)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-08 16:27:06
 */
@Mapper
@Repository
public interface PricesDao {

    /**
     * 根据条件统计行数
     *
     * @param text 条件
     * @return 总行数
     */
    int count(String text);

    /**
     * 通过ID查询单条数据
     *
     * @param priceid 主键
     * @return 实例对象
     */
    Prices queryById(Integer priceid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Prices> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("text")String text);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param prices 实例对象
     * @return 对象列表
     */
    List<Prices> queryAll(Prices prices);

    /**
     * 新增数据
     *
     * @param prices 实例对象
     * @return 影响行数
     */
    int insert(Prices prices);

    /**
     * 修改数据
     *
     * @param prices 实例对象
     * @return 影响行数
     */
    int update(Prices prices);

    /**
     * 通过主键删除数据
     *
     * @param priceid 主键
     * @return 影响行数
     */
    int deleteById(Integer priceid );

}