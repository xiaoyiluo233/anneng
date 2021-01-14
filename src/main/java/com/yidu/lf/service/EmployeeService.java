package com.yidu.lf.service;

import com.yidu.entity.Employee;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * (Employee)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 08:54:32
 */
public interface EmployeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param eid 主键
     * @return 实例对象
     */
    Employee queryById(Integer eid);

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
     * @param employee 实例对象
     * @return 对象列表
     */
    List<Employee> queryAll(Employee employee);
    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 成功返回真
     */
    boolean insert(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 成功返回真
     */
    boolean update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param eid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer eid);

    /**
     * 员工登录
     * @param ename 名字
     * @param epassword 密码
     * @param request 请求
     * @return 登录结果
     */
    String login(String ename, String epassword, HttpServletRequest request);

    /**
     * 通过角色id查询所有该角色的员工
     * @param roleid 角色id
     * @return 员工集合
     */
    List<Employee> selectEmpByRoleId(Integer roleid);
}