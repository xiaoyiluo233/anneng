package com.yidu.lf.dao;

import com.yidu.entity.Employeerole;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * (Employeerole)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-30 16:43:52
 */
@Repository
@Mapper
public interface EmployeeroleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param erid 主键
     * @return 实例对象
     */
    Employeerole queryById(Integer erid);

    /**
     * 通过员工ID查询单条数据
     *
     * @param eid 员工id
     * @return 实例对象
     */
    Employeerole queryByEid(Integer eid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param text 查询文本
     * @return 对象列表
     */
    List<Employeerole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("text") String text);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employeerole 实例对象
     * @return 对象列表
     */
    List<Employeerole> queryAll(Employeerole employeerole);

    /**
     * 新增数据
     *
     * @param employeerole 实例对象
     * @return 影响行数
     */
    int insert(Employeerole employeerole);

    /**
     * 修改数据
     *
     * @param employeerole 实例对象
     * @return 影响行数
     */
    int update(Employeerole employeerole);

    /**
     * 通过主键删除数据
     *
     * @param erid 主键
     * @return 影响行数
     */
    int deleteById(Integer erid);

    /**
     * 统计行数
     * @param text 查询文本
     * @return 返回行数
     */
    int count(String text);
}