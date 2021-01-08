package com.yidu.lf.controller;

import com.yidu.entity.Menu;
import com.yidu.lf.entity.Node;
import com.yidu.lf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * (Menu)表控制层
 *
 * @author LvFang
 * @since 2020-12-30 16:45:27
 */
@Controller
public class MenuController {
    /**
     * 菜单服务对象
     */
    @Autowired
    private MenuService menuService;

    /**
     * 查询所有菜单
     * @param offset 开始值
     * @param pageNumber 查询个数
     * @param text 查询文本
     * @return 所有菜单
     */
    @RequestMapping("/menu_selectAll")
    @ResponseBody
    public HashMap<String,Object> selectAll(int offset,int pageNumber,String text){
        return this.menuService.queryAllByLimit(offset,pageNumber,text);
    }

    /**
     * 修改菜单
     * @param menu 菜单对象
     * @return 修改结果
     */
    @ResponseBody
    @RequestMapping("/menu_update")
    public String update(Menu menu){
        //修改菜单并接收返回值
        boolean update = this.menuService.update(menu);
        //判断修改是否成功
        if (update){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    /**
     * 新增菜单
     * @param menu 菜单对象
     * @return 新增结果
     */
    @ResponseBody
    @RequestMapping("/menu_insert")
    public String insert(Menu menu){
        //新增菜单并接收返回值
        boolean insert = this.menuService.insert(menu);
        //判断新增是否成功
        if (insert){
            return "新增成功";
        }else{
            return "新增失败";
        }
    }

    /**
     * 根据菜单id删除菜单
     * @param menuid 菜单id
     * @return 返回删除结果
     */
    @ResponseBody
    @RequestMapping("/menu_delete")
    public String delete(String menuid){
        //将菜单id切割
        String[] split = menuid.split(",");
        //删除结果
        boolean result=true;
        //遍历切割后的菜单id
        for (String id : split) {
            //根据菜单id删除菜单并接收返回值
            boolean insert = this.menuService.deleteById(id);
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
     * 查询所有菜单
     * @return  返回tree所需数据
     */
    @ResponseBody
    @RequestMapping("menu_queryAllMenu")
    public List<Node> queryAllMenu(){
        return menuService.queryAllMenu();
    }
}