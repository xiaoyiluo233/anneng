package com.yidu.lf.service;

import com.yidu.entity.Rolemenu;
import java.util.List;

/**
 * (Rolemenu)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 16:44:45
 */
public interface RolemenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param rmid 主键
     * @return 实例对象
     */
    Rolemenu queryById(Integer rmid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Rolemenu> queryAllByLimit(int offset, int limit);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param rolemenu 实例对象
     * @return 对象列表
     */
    List<Rolemenu> queryAll(Rolemenu rolemenu);

    /**
     * 新增数据
     * @param roleId 角色id
     * @param menuIds 菜单id
     * @return 新增结果
     */
    String insert(int roleId,String menuIds);

    /**
     * 修改数据
     *
     * @param rolemenu 实例对象
     * @return 修改结果
     */
    String update(Rolemenu rolemenu);

    /**
     * 通过主键删除数据
     *
     * @param rmid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer rmid);

    /**
     * 通过角色id查询菜单id
     * @param roleId 角色id
     * @return 菜单集合
     */
    String selectMenuIdByRoleId(Integer roleId);

}