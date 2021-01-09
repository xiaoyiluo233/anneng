package com.yidu.lf.service;

import com.yidu.entity.Employeerole;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * (Employeerole)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 16:43:52
 */
public interface EmployeeroleService {

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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param limit 查询文本
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(int offset, int limit,String text);
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
     * @return 实例对象
     */
    boolean insert(Employeerole employeerole);

    /**
     * 修改数据
     *
     * @param employeerole 实例对象
     * @return 实例对象
     */
    boolean update(Employeerole employeerole);

    /**
     * 通过主键删除数据
     *
     * @param erid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer erid);


}