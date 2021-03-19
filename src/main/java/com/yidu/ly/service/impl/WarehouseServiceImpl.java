package com.yidu.ly.service.impl;

import com.yidu.entity.Warehouse;
import com.yidu.ly.dao.WarehouseDao;
import com.yidu.ly.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * (Warehouse)入库表业务实现层
 *
 * @author makejava
 * @since 2020-12-31 13:53:29
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseDao warehouseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param wid 主键
     * @return 实例对象
     */
    @Override
    public Warehouse queryById(Integer wid) {
        return this.warehouseDao.queryById(wid);
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
    public HashMap<String,Object> queryAllByLimit(int offset, int limit, String name) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("rows",warehouseDao.queryAllByLimit(offset,limit,name));
        map.put("total",warehouseDao.count(name));
        return map;
    }

    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Warehouse warehouse) {
        String one;
        if (warehouseDao.insert(warehouse)>0){
            one="新增成功";
        }else {
            one="新增失败";
        }
        return one;
    }

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Warehouse warehouse) {
        String one;
        if (warehouseDao.update(warehouse)>0){
            one="修改成功";
        }else {
            one="修改失败";
        }
        return one;
    }

    /**
     * 通过主键删除数据
     *
     * @param wid 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(Integer wid) {
        String one;
        if (warehouseDao.deleteById(wid)>0){
            one="删除成功";
        }else {
            one="删除失败";
        }
        return one;
    }

    @Override
    public Warehouse queryByWname(String wname) {
        return warehouseDao.queryByWname(wname);
    }

}