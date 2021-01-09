package com.yidu.lf.service.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.yidu.entity.Menu;
import com.yidu.lf.dao.MenuDao;
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
        Menu menu=new Menu();
        menu.setLevelid("root");
        List<Menu> menuLists = menuDao.queryAll(menu);
        for (Menu menuList : menuLists) {
            String menuid = menuList.getMenuid();
            Menu menu1=new Menu();
            menu1.setLevelid(menuid);
            List<Menu> menus = menuDao.queryAll(menu1);
            menuList.setChildMenuList(menus);
        }
        List<Node> nodeList=new ArrayList<>();
        for (Menu menuParent : menuLists) {
            Node node=new Node();
            node.setId(menuParent.getMenuid());
            node.setText(menuParent.getTitle());
            List<NodeChild> nodes=new ArrayList<>();
            for (Menu menuChild : menuParent.getChildMenuList()) {
                NodeChild nodeChild=new NodeChild();
                nodeChild.setId(menuChild.getMenuid());
                nodeChild.setText(menuChild.getTitle());
                nodes.add(nodeChild);
            }
            node.setNodes(nodes);
            nodeList.add(node);
        }
        return nodeList;
    }
}