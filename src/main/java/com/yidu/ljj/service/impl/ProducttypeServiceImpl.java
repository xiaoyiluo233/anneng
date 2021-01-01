package com.yidu.ljj.service.impl;

import com.yidu.entity.Producttype;
import com.yidu.ljj.dao.ProducttypeDao;
import com.yidu.ljj.service.ProducttypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Producttype)表服务实现类
 *
 * @author makejava
 * @since 2020-12-29 15:19:21
 */
@Service
public class ProducttypeServiceImpl implements ProducttypeService {

    @Autowired
    ProducttypeDao producttypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ptid 主键
     * @return 实例对象
     */
    @Override
    public Producttype queryById(int ptid ) {
        return this.producttypeDao.queryById(ptid);
    }

    @Override
    public List<Producttype> queryAll(Producttype producttype) {
        return producttypeDao.queryAll(producttype);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(int offset, int limit,String text) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("rows",producttypeDao.queryAllByLimit(offset, limit,text));
        map.put("total",producttypeDao.count(text));
        return map;
    }

    /**
     * 新增数据
     *
     * @param producttype 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Producttype producttype) {
        return producttypeDao.insert(producttype)>0?"新增成功!":"新增失败...";
    }

    /**
     * 修改数据
     *
     * @param producttype 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Producttype producttype) {
        return producttypeDao.update(producttype)>0?"修改成功!":"修改失败...";
    }

    /**
     * 通过主键删除数据
     *
     * @param ptid 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(int ptid) {
        return producttypeDao.deleteById(ptid)>0?"删除成功!":"删除失败...";
    }
}