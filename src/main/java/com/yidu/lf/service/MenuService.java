package com.yidu.lf.service;

import com.yidu.entity.Menu;
import com.yidu.lf.entity.Node;

import java.util.HashMap;
import java.util.List;

/**
 * (Menu)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 16:45:27
 */
public interface MenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param menuid 主键
     * @return 实例对象
     */
    Menu queryById(String menuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(int offset, int limit,String text);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param menu 实例对象
     * @return 对象列表
     */
    List<Menu> queryAll(Menu menu);

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    boolean insert(Menu menu);

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    boolean update(Menu menu);

    /**
     * 通过主键删除数据
     *
     * @param menuid 主键
     * @return 是否成功
     */
    boolean deleteById(String menuid);

    /**
     * 查询所有菜单
     * @return  返回tree所需数据
     */
    List<Node> queryAllMenu();

    /**
     *
     * @return
     */
    String delete(String menuid);
}