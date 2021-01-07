package com.yidu.lf.service.impl;

import com.yidu.entity.Role;
import com.yidu.lf.dao.RoleDao;
import com.yidu.lf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 16:44:34
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleid 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Integer roleid) {
        return this.roleDao.queryById(roleid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param text 查询文本
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(int offset, int limit ,String text) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("rows",this.roleDao.queryAllByLimit(offset, limit, text));
        map.put("total",this.roleDao.count(text));
        return map;
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param role 实例对象
     * @return 对象列表
     */
    @Override
    public List<Role> queryAll(Role role){
        return this.roleDao.queryAll(role);
    }
    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Role role) {
        return this.roleDao.insert(role)>0;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Role role) {
        return this.roleDao.update(role)>0;
    }

    /**
     * 通过主键删除数据
     *
     * @param roleid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roleid) {
        return this.roleDao.deleteById(roleid) > 0;
    }
}