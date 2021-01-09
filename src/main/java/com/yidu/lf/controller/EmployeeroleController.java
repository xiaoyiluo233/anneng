package com.yidu.lf.controller;

import com.yidu.entity.Employee;
import com.yidu.entity.Employeerole;
import com.yidu.entity.Role;
import com.yidu.lf.service.EmployeeroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Employeerole)表控制层
 *
 * @author Lvfang
 * @since 2020-12-30 16:43:52
 */
@Controller
public class EmployeeroleController {
    /**
     * 服务对象
     */
    @Autowired
    private EmployeeroleService employeeroleService;

    /**
     * 查询所有员工角色
     * @param offset 开始值
     * @param pageNumber 查询个数
     * @param text 查询文本
     * @return 所有员工角色
     */
    @ResponseBody
    @RequestMapping("empRole_selectAll")
    public HashMap<String,Object> selectAll(int offset, int pageNumber, String text){
        return this.employeeroleService.queryAllByLimit(offset,pageNumber,text);
    }

    /**
     * 修改员工角色
     * @param empRole 员工角色对象
     * @return 修改结果
     */
    @ResponseBody
    @RequestMapping("/empRole_update")
    public String update(Employeerole empRole){
        //修改员工角色并接收返回值
        boolean update = this.employeeroleService.update(empRole);
        //判断修改是否成功
        if (update){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    /**
     * 新增员工角色
     * @param empRole 员工角色对象
     * @return 新增结果
     */
    @ResponseBody
    @RequestMapping("/empRole_insert")
    public String insert(Employeerole empRole){
        //新增员工角色并接收返回值
        boolean insert = this.employeeroleService.insert(empRole);
        //判断新增是否成功
        if (insert){
            return "新增成功";
        }else{
            return "新增失败";
        }
    }

    /**
     * 根据主键删除员工角色
     * @param erid 主键
     * @return 返回删除结果
     */
    @ResponseBody
    @RequestMapping("/empRole_delete")
    public String delete(String erid){
        //将员工角色id切割
        String[] split = erid.split(",");
        //删除结果
        boolean result=true;
        //遍历切割后的员工角色id
        for (String id : split) {
            //根据员工角色id删除并接收返回值
            boolean delete = this.employeeroleService.deleteById(Integer.parseInt(id));
            //判断删除是否不成功
            if (!delete){
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
     * 根据员工id判断是否存在
     * @param eid 员工id
     * @return 是否存在结果
     */
    @ResponseBody
    @RequestMapping("empRole_boolByEid")
    public String boolById(Integer eid){
        Employeerole employeerole=new Employeerole();
        employeerole.setEid(eid);
        //根据员工id查询员工详细信息
        List<Employeerole> employeeroles = this.employeeroleService.queryAll(employeerole);
        if (employeeroles.size()>0){
            return "no";
        }else {
            return "ok";
        }
    }
}