package com.yidu.lixiang.dao;

import com.yidu.entity.Warerecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 仓库记录表持久层
 * @author: lixiang
 * @date: 2021/3/11 18:28
 * @version 1.0
 */
@Repository
@Mapper
public interface WarerecordDao {
    /**
     * 连表查询出员工名、仓库名以及仓库记录表的基本数据
     * @return 数据集合
     */
    List<HashMap<String,Object>> getMainData();

    /**
     * 通过ID查询单条数据
     * @param wrid 主键
     * @return 实例对象
     */
    Warerecord queryById(Integer wrid);

    /**
     * 查询指定行数据
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Warerecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     * @param warerecord 实例对象
     * @return 对象列表
     */
    List<Warerecord> queryAll(Warerecord warerecord);

    /**
     * 新增数据
     * @param warerecord 实例对象
     * @return 影响行数
     */
    int insert(Warerecord warerecord);

    /**
     * 修改数据
     * @param warerecord 实例对象
     * @return 影响行数
     */
    int update(Warerecord warerecord);

    /**
     * 通过主键删除数据
     * @param wrid 主键
     * @return 影响行数
     */
    int deleteById(Integer wrid);

}