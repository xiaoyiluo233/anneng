package com.yidu.lf.controller;

import com.yidu.entity.Rolemenu;
import com.yidu.lf.service.RolemenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Rolemenu)表控制层
 *
 * @author Lvfang
 * @since 2020-12-30 16:44:45
 */
@Controller
public class RolemenuController {
    /**
     * 服务对象
     */
    @Autowired
    private RolemenuService rolemenuService;

    /**
     * 新增数据
     * @param roleId 角色id
     * @param menuIds 菜单id
     * @return 新增结果
     */
    @ResponseBody
    @RequestMapping("roleMenu_insert")
    public String insert(int roleId,String menuIds){
        //调用新增方法并接收返回结果
        String insert = rolemenuService.insert(roleId, menuIds);
        //返回结果
        return insert;
    }

    /**
     * 通过角色id查询菜单id
     * @param roleId 角色id
     * @return 角色集合
     */
    @ResponseBody
    @RequestMapping("roleMenu_selectMenuIdByRoleId")
    public String selectMenuIdByRoleId(Integer roleId){
        //调用查询方法并返回
        return this.rolemenuService.selectMenuIdByRoleId(roleId);
    }

}