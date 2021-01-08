package com.yidu.lf.service;

import com.yidu.entity.Role;

import java.util.HashMap;
import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 16:44:34
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleid 主键
     * @return 实例对象
     */
    Role queryById(Integer roleid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param text 查询文本
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(int offset, int limit,String text);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param role 实例对象
     * @return 对象列表
     */
    List<Role> queryAll(Role role);
    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 是否新增成功
     */
    boolean insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 是否修改成功
     */
    boolean update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param roleid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roleid);

    String delete(String roleid);
}