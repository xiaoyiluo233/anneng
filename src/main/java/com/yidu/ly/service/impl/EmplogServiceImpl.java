package com.yidu.ly.service.impl;

import com.yidu.entity.Emplog;
import com.yidu.ly.dao.EmplogDao;
import com.yidu.ly.service.EmplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * (Emplog) 员工表业务实现层
 *
 * @author makejava
 * @since 2021-01-11 09:54:50
 */
@Service
public class EmplogServiceImpl implements EmplogService {

    @Autowired
    private EmplogDao emplogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param elid 主键
     * @return 实例对象
     */
    @Override
    public Emplog queryById(Integer elid) {
        return emplogDao.queryById(elid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param name 查询值
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(int offset, int limit, Integer name) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("rows",emplogDao.queryAllByLimit(offset, limit, name));
        map.put("total",emplogDao.count());
        return map;
    }

    /**
     * 新增数据
     *
     * @param emplog 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Emplog emplog) {
        return emplogDao.insert(emplog)>0?"新增成功":"新增失败";
    }

    /**
     * 修改数据
     *
     * @param emplog 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Emplog emplog) {
        return emplogDao.update(emplog)>0?"修改成功":"修改失败";
    }

    /**
     * 通过主键删除数据
     *
     * @param elid 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(Integer elid) {
        return emplogDao.deleteById(elid) > 0?"删除成功":"删除失败";
    }

}