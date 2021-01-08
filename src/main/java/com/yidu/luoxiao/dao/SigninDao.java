package com.yidu.luoxiao.dao;

import com.yidu.entity.Signin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Signin)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-06 11:00:33
 */
@Repository
@Mapper
public interface SigninDao {

    /**
     * 通过ID查询单条数据
     *
     * @param signid 主键
     * @return 实例对象
     */
    Signin queryById(Integer signid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Signin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param signin 实例对象
     * @return 对象列表
     */
    List<Signin> queryAll(Signin signin);

    /**
     * 新增数据
     *
     * @param signin 实例对象
     * @return 影响行数
     */
    int insert(Signin signin);

    /**
     * 修改数据
     *
     * @param signin 实例对象
     * @return 影响行数
     */
    int update(Signin signin);

    /**
     * 通过主键删除数据
     *
     * @param signid 主键
     * @return 影响行数
     */
    int deleteById(Integer signid);

}