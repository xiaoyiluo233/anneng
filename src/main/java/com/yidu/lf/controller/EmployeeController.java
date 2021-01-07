package com.yidu.lf.controller;

import com.yidu.entity.*;
import com.yidu.lf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * (Employee)表控制层
 *
 * @author makejava
 * @since 2020-12-30 08:54:32
 */
@Controller
public class EmployeeController {
    /**
     * 员工服务对象
     */
    @Autowired
    private EmployeeService employeeService;


    /**
     * 通过员工名和密码判断是否登录成功
     *
     * @param ename 员工名
     * @param epassword 密码
     * @return 登录结果
     */
    @RequestMapping("emp_login")
    @ResponseBody
    public String login(String ename, String epassword, HttpServletRequest request) {
        return this.employeeService.login(ename,epassword,request);
    }
    /**
     * 查询所有员工
     * @param offset 开始值
     * @param pageNumber 查询个数
     * @param text 查询文本
     * @return 所有员工
     */
    @RequestMapping("/emp_selectAll")
    @ResponseBody
    public HashMap<String,Object> selectAll(int offset,int pageNumber,String text){
        return this.employeeService.queryAllByLimit(offset,pageNumber,text);
    }

    /**
     * 修改菜单
     * @param employee 员工对象
     * @return 修改结果
     */
    @ResponseBody
    @RequestMapping("/emp_update")
    public String update(Employee employee){
        //修改员工并接收返回值
        boolean update = this.employeeService.update(employee);
        //判断修改是否成功
        if (update){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    /**
     * 新增员工
     * @param employee 员工对象
     * @return 新增结果
     */
    @ResponseBody
    @RequestMapping("/emp_insert")
    public String insert(Employee employee){
        //新增员工并接收返回值
        boolean insert = this.employeeService.insert(employee);
        //判断新增是否成功
        if (insert){
            return "新增成功";
        }else{
            return "新增失败";
        }
    }

    /**
     * 根据员工id删除员工
     * @param eid 员工id
     * @return 返回删除结果
     */
    @ResponseBody
    @RequestMapping("/emp_delete")
    public String delete(String eid){
        //将员工id切割
        String[] split = eid.split(",");
        //删除结果
        boolean result=true;
        //遍历切割后的员工id
        for (String id : split) {
            //根据员工id删除菜单并接收返回值
            boolean insert = this.employeeService.deleteById(Integer.parseInt(id));
            //判断删除是否不成功
            if (!insert){
                //删除结果改为假
                result=false;
                //结束循环
                break;
            }
        }
        //判断删除结果是否成功
        if (result){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    /**
     * 根据员工id查询员工姓名
     * @param eid 员工id
     * @return 返回员工姓名
     */
    @ResponseBody
    @RequestMapping("emp_selectNameById")
    public String selectNameById(Integer eid){
        //根据员工id查询员工详细信息
        Employee employee = this.employeeService.queryById(eid);
        //返回员工姓名
        return employee.getEname();
    }

    /**
     * 根据员工id判断是否存在
     * @param eid 员工id
     * @return 是否存在结果
     */
    @ResponseBody
    @RequestMapping("emp_boolById")
    public String boolById(Integer eid){
        //根据员工id查询员工详细信息
        Employee employee = this.employeeService.queryById(eid);
        if (employee!=null){
            return "ok";
        }else {
            return "no";
        }
    }
}