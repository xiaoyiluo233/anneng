package com.yidu.lf.dao;

import com.yidu.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Employee)表数据库访问层
 *
 * @author LvFang
 * @since 2020-12-30 08:54:31
 */
@Repository
@Mapper
public interface EmployeeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param eid 主键
     * @return 实例对象
     */
    Employee queryById(Integer eid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Employee> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("text") String text);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employee 实例对象
     * @return 对象列表
     */
    List<Employee> queryAll(Employee employee);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 影响行数
     */
    int insert(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 影响行数
     */
    int update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param eid 主键
     * @return 影响行数
     */
    int deleteById(Integer eid);

    /**
     * 统计行数
     * @param text 查询文本
     * @return 行数
     */
    int count(String text);

    /**
     * 通过角色id查询所有该角色的员工
     * @param roleid 角色id
     * @return 员工集合
     */
    List<Employee> selectEmpByRoleId(Integer roleid);
}