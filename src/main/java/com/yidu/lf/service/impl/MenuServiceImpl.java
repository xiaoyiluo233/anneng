package com.yidu.lf.service.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.yidu.entity.Menu;
import com.yidu.lf.dao.MenuDao;
import com.yidu.lf.dao.RolemenuDao;
import com.yidu.lf.entity.Node;
import com.yidu.lf.entity.NodeChild;
import com.yidu.lf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 16:45:27
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RolemenuDao rolemenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param menuid 主键
     * @return 实例对象
     */
    @Override
    public Menu queryById(String menuid) {
        return this.menuDao.queryById(menuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public HashMap<String, Object> queryAllByLimit(int offset, int limit,String text) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("rows",menuDao.queryAllByLimit(offset,limit,text));
        map.put("total",menuDao.count(text));
        return map;
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param menu 实例对象
     * @return 对象列表
     */
    public List<Menu> queryAll(Menu menu){
        return this.menuDao.queryAll(menu);
    }

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Menu menu) {
        return this.menuDao.insert(menu)>0;
    }

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Menu menu) {
        return this.menuDao.update(menu)>0;

    }

    /**
     * 通过主键删除数据
     *
     * @param menuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String menuid) {
        return this.menuDao.deleteById(menuid) > 0;
    }

    /**
     * 查询所有菜单
     * @return  返回tree所需数据
     */
    @Override
    public List<Node> queryAllMenu() {
        //创建一个菜单对象
        Menu menu=new Menu();
        //设置上级为root
        menu.setLevelid("root");
        //根据菜单对象查询所有父级菜单并用集合接收
        List<Menu> menuParentList = menuDao.queryAll(menu);
        //遍历所有父级菜单集合
        for (Menu menuList : menuParentList) {
            //得到父级菜单的主键
            String menuid = menuList.getMenuid();
            //创建一个子菜单对象
            Menu menuChild=new Menu();
            //设置子菜单对象的上级为父级菜单主键
            menuChild.setLevelid(menuid);
            //根据子菜单查询子菜单集合
            List<Menu> menus = menuDao.queryAll(menuChild);
            //将子菜单集合设置到父级菜单中
            menuList.setChildMenuList(menus);
        }
        //声明一个节点集合
        List<Node> nodeList=new ArrayList<>();
        //遍历父级菜单集合
        for (Menu menuParent : menuParentList) {
            //创建一个节点对象
            Node node=new Node();
            //将父级菜单的主键设置为节点id
            node.setId(menuParent.getMenuid());
            //将父级菜单的标题设置为节点文本
            node.setText(menuParent.getTitle());
            //声明一个子节点集合
            List<NodeChild> nodes=new ArrayList<>();
            //遍历父级菜单中的子菜单集合
            for (Menu menuChild : menuParent.getChildMenuList()) {
                //创建一个子节点对象
                NodeChild nodeChild=new NodeChild();
                //将子菜单的主键设置为子节点id
                nodeChild.setId(menuChild.getMenuid());
                //将子菜单的标题设置为子节点文本
                nodeChild.setText(menuChild.getTitle());
                //将子节点存入子节点集合中
                nodes.add(nodeChild);
            }
            //将子节点集合设置到节点对象中
            node.setNodes(nodes);
            //将节点对象添加到节点集合中
            nodeList.add(node);
        }
        //返回节点集合
        return nodeList;
    }

    @Override
    public String delete(String menuid) {
        //将菜单id切割
        String[] split = menuid.split(",");
        //删除结果
        boolean result=true;
        //遍历切割后的菜单id
        for (String id : split) {
            //根据菜单id删除菜单并接收返回值
            int insert = this.menuDao.deleteById(id);
            //判断删除是否不成功
            if (insert<1){
                //删除结果改为假
                result=false;
                //结束循环
                break;
            }else {
                this.rolemenuDao.deleteByMenuId(id);
            }
        }
        //判断删除结果是否成功
        if (result){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
}