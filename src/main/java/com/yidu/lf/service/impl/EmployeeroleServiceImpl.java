package com.yidu.lf.service.impl;

import com.yidu.entity.Employeerole;
import com.yidu.lf.dao.EmployeeroleDao;
import com.yidu.lf.service.EmployeeroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Employeerole)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 16:43:52
 */
@Service("employeeroleService")
public class EmployeeroleServiceImpl implements EmployeeroleService {
    @Autowired
    private EmployeeroleDao employeeroleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param erid 主键
     * @return 实例对象
     */
    @Override
    public Employeerole queryById(Integer erid) {
        return this.employeeroleDao.queryById(erid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(int offset, int limit ,String text) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("rows",this.employeeroleDao.queryAllByLimit(offset, limit, text));
        map.put("total",this.employeeroleDao.count(text));
        return map;
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param employeerole 实例对象
     * @return 对象列表
     */
    @Override
    public List<Employeerole> queryAll(Employeerole employeerole){
        return this.employeeroleDao.queryAll(employeerole);
    }

    /**
     * 通过员工ID查询单条数据
     *
     * @param eid 员工id
     * @return 实例对象
     */
    @Override
    public Employeerole queryByEid(Integer eid){
        return  this.employeeroleDao.queryByEid(eid);
    }

    /**
     * 新增数据
     *
     * @param employeerole 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Employeerole employeerole) {
        return this.employeeroleDao.insert(employeerole)>0;
    }

    /**
     * 修改数据
     *
     * @param employeerole 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Employeerole employeerole) {
        int update = this.employeeroleDao.update(employeerole);
        return update>0;
    }

    /**
     * 通过主键删除数据
     *
     * @param erid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer erid) {
        return this.employeeroleDao.deleteById(erid) > 0;
    }
}