package com.yidu.lf.controller;

import com.yidu.entity.Employee;
import com.yidu.entity.Menu;
import com.yidu.entity.Role;
import com.yidu.lf.service.MenuService;
import com.yidu.lf.service.RoleService;
import com.yidu.lf.service.RolemenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author Lvfang
 * @since 2020-12-30 16:44:34
 */
@Controller
public class RoleController {
    /**
     * 角色服务对象
     */
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色
     * @param offset 开始值
     * @param pageNumber 查询个数
     * @param text 查询文本
     * @return 所有角色
     */
    @RequestMapping("/role_selectAll")
    @ResponseBody
    public HashMap<String,Object> selectAll(int offset, int pageNumber, String text){
        return this.roleService.queryAllByLimit(offset,pageNumber,text);
    }

    /**
     * 修改角色
     * @param role 角色对象
     * @return 修改结果
     */
    @ResponseBody
    @RequestMapping("/role_update")
    public String update(Role role){
        //修改角色并接收返回值
        boolean update = this.roleService.update(role);
        //判断修改是否成功
        if (update){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    /**
     * 新增角色
     * @param role 角色对象
     * @return 新增结果
     */
    @ResponseBody
    @RequestMapping("/role_insert")
    public String insert(Role role){
        //新增角色并接收返回值
        boolean insert = this.roleService.insert(role);
        //判断新增是否成功
        if (insert){
            return "新增成功";
        }else{
            return "新增失败";
        }
    }

    /**
     * 根据角色id删除权限
     * @param roleid 角色id
     * @return 返回删除结果
     */
    @ResponseBody
    @RequestMapping("/role_delete")
    public String delete(String roleid){
        //调用删除方法
        return roleService.delete(roleid);
    }
    @ResponseBody
    @RequestMapping("role_selectNameById")
    public String selectNameById(Integer roleid){
        //根据角色id查询角色详细信息
        Role role = this.roleService.queryById(roleid);
        //返回角色名
        return role.getRolename();
    }

    @ResponseBody
    @RequestMapping("role_queryAll")
    public List<Role> queryAll(){
        //查询所有角色并接收
        List<Role> roles = this.roleService.queryAll(null);
        //返回角色集合
        return roles;
    }
}