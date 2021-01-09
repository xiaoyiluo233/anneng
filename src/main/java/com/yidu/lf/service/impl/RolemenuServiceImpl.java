package com.yidu.lf.service.impl;

import com.yidu.entity.Role;
import com.yidu.entity.Rolemenu;
import com.yidu.lf.dao.RolemenuDao;
import com.yidu.lf.service.RolemenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Rolemenu)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 16:44:45
 */
@Service("rolemenuService")
public class RolemenuServiceImpl implements RolemenuService {
    @Autowired
    private RolemenuDao rolemenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param rmid 主键
     * @return 实例对象
     */
    @Override
    public Rolemenu queryById(Integer rmid) {
        //调用根据id查询方法并接收结果
        Rolemenu rolemenu = this.rolemenuDao.queryById(rmid);
        //返回接收结果
        return rolemenu;
    }
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Rolemenu> queryAllByLimit(int offset, int limit) {
        //调用查询方法并接收结果
        List<Rolemenu> rolemenus = this.rolemenuDao.queryAllByLimit(offset, limit);
        //返回接收结果
        return rolemenus;
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param rolemenu 实例对象
     * @return 对象列表
     */
    @Override
    public List<Rolemenu> queryAll(Rolemenu rolemenu){
        //调用查询方法并接收结果
        List<Rolemenu> rolemenus = this.rolemenuDao.queryAll(rolemenu);
        //返回接收结果
        return rolemenus;
    }

    /**
     * 新增数据
     *
     * @param roleId 角色id
     * @param menuIds 菜单id
     * @return 新增结果
     */
    @Override
    public String insert(int roleId, String menuIds) {
        //根据角色id先将表中相关数据删除
        this.rolemenuDao.deleteByRoleId(roleId);
        //将菜单id切割并接收
        String[] split = menuIds.split("-");
        //遍历切割后的菜单id
        for (String menuid : split) {
            //创建角色菜单对象
            Rolemenu rolemenu=new Rolemenu();
            //设置角色id
            rolemenu.setRoleid(roleId);
            //设置菜单id
            rolemenu.setMenuid(menuid);
            //调用菜单角色新增方法
            this.rolemenuDao.insert(rolemenu);
        }
        return "修改成功";
    }


    /**
     * 修改数据
     *
     * @param rolemenu 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Rolemenu rolemenu) {
        //调用修改方法并接收结果
        int update = this.rolemenuDao.update(rolemenu);
        //判断修改结果是否大于0
        if (update>0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param rmid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer rmid) {
        return this.rolemenuDao.deleteById(rmid) > 0;
    }

    /**
     * 通过角色id查询菜单id
     *
     * @param roleId 角色id
     * @return 菜单集合
     */
    public String selectMenuIdByRoleId(Integer roleId){
        //调用查询方法并接收值
        List<String> menuidList = this.rolemenuDao.selectMenuIdByRoleId(roleId);
        String menuids="";
        for(int i=0;i<menuidList.size();i++){
            if (i==menuidList.size()-1) {
                menuids += menuidList.get(i);
            }else {
                menuids += menuidList.get(i) + "-";
            }
        }
        //返回菜单集合
        return menuids;
    }
}