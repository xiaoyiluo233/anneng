package com.yidu.lf.dao;

import com.yidu.entity.Rolemenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Rolemenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-30 16:44:45
 */
@Repository
@Mapper
public interface RolemenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rmid 主键
     * @return 实例对象
     */
    Rolemenu queryById(Integer rmid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Rolemenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rolemenu 实例对象
     * @return 对象列表
     */
    List<Rolemenu> queryAll(Rolemenu rolemenu);

    /**
     * 新增数据
     *
     * @param rolemenu 实例对象
     * @return 影响行数
     */
    int insert(Rolemenu rolemenu);

    /**
     * 修改数据
     *
     * @param rolemenu 实例对象
     * @return 影响行数
     */
    int update(Rolemenu rolemenu);

    /**
     * 通过主键删除数据
     *
     * @param rmid 主键
     * @return 影响行数
     */
    int deleteById(Integer rmid);

    /**
     * 通过角色id删除数据
     *
     * @param roleId 角色id
     * @return 影响行数
     */
    int deleteByRoleId(Integer roleId);

    /**
     * 通过菜单id删除数据
     *
     * @param menuid 菜单id
     * @return 影响行数
     */
    int deleteByMenuId(String menuid);

    /**
     * 通过角色id查询菜单id
     * @param roleId 角色id
     * @return 菜单集合
     */
    List<String> selectMenuIdByRoleId(Integer roleId);

}