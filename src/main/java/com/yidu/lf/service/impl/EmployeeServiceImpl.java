package com.yidu.lf.service.impl;

import com.yidu.entity.*;
import com.yidu.lf.dao.EmployeeDao;
import com.yidu.lf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * (Employee)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 08:54:32
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    /**
     * 员工权限服务对象
     */
    @Autowired
    private EmployeeroleService employeeroleService;
    /**
     * 角色服务对象
     */
    @Autowired
    private RoleService roleService;
    /**
     * 角色菜单服务对象
     */
    @Autowired
    private RolemenuService rolemenuService;
    /**
     * 菜单服务对象
     */
    @Autowired
    private MenuService menuService;

    /**
     * 通过ID查询单条数据
     *
     * @param eid 主键
     * @return 实例对象
     */
    @Override
    public Employee queryById(Integer eid) {
        return this.employeeDao.queryById(eid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(int offset, int limit,String text) {
        //申明一个map
        HashMap<String,Object> hashMap=new HashMap<>();
        //将查询出的员工列表放入map
        hashMap.put("rows",this.employeeDao.queryAllByLimit(offset, limit,text));
        //将总行数放入map
        hashMap.put("total",this.employeeDao.count(text));
        //返回map
        return hashMap;
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param employee 实例对象
     * @return 对象列表
     */
    @Override
    public List<Employee> queryAll(Employee employee){
        return this.employeeDao.queryAll(employee);
    }
    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 成功返回真
     */
    @Override
    public boolean insert(Employee employee) {
        return this.employeeDao.insert(employee)>0;
    }

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 成功返回真
     */
    @Override
    public boolean update(Employee employee) {
        return this.employeeDao.update(employee)>0;

    }

    /**
     * 通过主键删除数据
     *
     * @param eid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer eid) {
        return this.employeeDao.deleteById(eid) > 0;
    }

    /**
     * 员工登录
     * @param ename 名字
     * @param epassword 密码
     * @param request 请求
     * @return 登录结果
     */
    @Override
    public String login(String ename, String epassword, HttpServletRequest request){
        //创建员工对象
        Employee employee=new Employee();
        //设置登录时的员工名
        employee.setEname(ename);
        //设置登录时的密码
        employee.setEpassword(epassword);
        //根据员工对象筛选查询全部
        List<Employee> employeeList = this.employeeDao.queryAll(employee);
        //判断查询结果集合大小
        if (employeeList.size() > 0){
            //得到登录成功的对象
            Employee employee1=employeeList.get(0);
            /**
             *  根据员工id查询它的角色id
             */
            Employeerole employeerole = employeeroleService.queryByEid(employee1.getEid());
            int roleId=employeerole.getRoleid();
            /**
             * 根据角色id查询权限名
             */
            Role role = roleService.queryById(roleId);
            String roleName = role.getRolename();
            //创建角色限菜单对象
            Rolemenu rolemenu=new Rolemenu();
            //权限菜单对象设置角色id
            rolemenu.setRoleid(roleId);
            //根据角色菜单对象查询所负责的角色菜单集合
            List<Rolemenu> roleMenus = rolemenuService.queryAll(rolemenu);
            //申明一个菜单集合
            List<Menu> menus=new ArrayList<>();
            //循环查询出来的角色菜单集合
            for (Rolemenu roleMenu : roleMenus) {
                //取出集合中的菜单id
                String menuId = roleMenu.getMenuid();
                //根据菜单id查询菜单信息;
                Menu menu = menuService.queryById(menuId);
                //存入菜单集合
                menus.add(menu);
            }
            //申明一个菜单map
            HashMap<String,Menu> menuHashMap=new HashMap<>();
            //循环菜单集合
            for (Menu menu : menus) {
                //取出菜单的上级id
                String levelid = menu.getLevelid();
                //判断上级id是否是root
                if (levelid.equals("root")) {
                    //键为菜单id存入菜单map
                    menuHashMap.put(menu.getMenuid(), menu);
                } else {
                    Menu menu1 = menuHashMap.get(levelid);
                    List<Menu> childMenuList = menu1.getChildMenuList();
                    childMenuList.add(menu);
                    menu1.setChildMenuList(childMenuList);
                    menuHashMap.put(levelid, menu1);
                }
            }
            //得到会话
            HttpSession session = request.getSession();
            //将登录员工存入会话
            session.setAttribute("employee",employee1);
            //将角色名存入会话
            session.setAttribute("roleName",roleName);
            //将菜单存入会话
            session.setAttribute("menuList",menuHashMap);
            //返回成功
            return "登录成功";
        }
        //返回失败
        return "登录失败";
    }
}