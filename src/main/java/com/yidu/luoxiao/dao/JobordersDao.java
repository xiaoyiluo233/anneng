package com.yidu.luoxiao.dao;

import com.yidu.entity.Joborders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Joborders)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-30 14:21:15
 */
@Repository
@Mapper
public interface JobordersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param jid 主键
     * @return 实例对象
     */
    Joborders queryById(Integer jid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Joborders> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param joborders 实例对象
     * @return 对象列表
     */
    List<Joborders> queryAll(Joborders joborders);

    /**
     * 新增数据
     *
     * @param joborders 实例对象
     * @return 影响行数
     */
    int insert(Joborders joborders);

    /**
     * 修改数据
     *
     * @param joborders 实例对象
     * @return 影响行数
     */
    int update(Joborders joborders);

    /**
     * 通过主键删除数据
     *
     * @param jid 主键
     * @return 影响行数
     */
    int deleteById(Integer jid);

}