package com.yidu.lixiang.service.impl;

import com.yidu.entity.Trucks;
import com.yidu.entity.Trucks;
import com.yidu.lixiang.dao.TrucksDao;
import com.yidu.lixiang.service.TrucksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Trucks)表服务实现类
 *
 * @author lixiang
 * @since 2020-12-29 10:32:52
 */
@Service
public class TrucksServiceImpl implements TrucksService {
    @Autowired
    private TrucksDao trucksDao;

    /**
     * 查询所有货车
     * @param trucks 货车实体
     * @return 货车集合
     */
    @Override
    public HashMap<String,Object> queryAll(Trucks trucks) {
        //创建map集合
        HashMap<String,Object> map=new HashMap<>();
        //添加行数据
        map.put("rows",trucksDao.queryAll(trucks));
        //添加总行数
        map.put("total",trucksDao.count(trucks));
        //返回map集合
        return map;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    @Override
    public Trucks queryById(Integer tid) {
        return this.trucksDao.queryById(tid);
    }

    /**
     * 分页查询多条数据
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(Integer offset, Integer limit,Trucks trucks) {
        //创建map集合
        HashMap<String,Object> map=new HashMap<>();
        //添加行数据
        map.put("rows",trucksDao.queryAllByLimit(offset, limit, trucks));
        //添加总行数
        map.put("total",trucksDao.count(trucks));
        //返回map集合
        return map;
    }

    /**
     * 新增数据
     *
     * @param trucks 实例对象
     * @return 实例对象
     */
    @Override
    public Trucks insert(Trucks trucks) {
        //this.trucksDao.insert(trucks);
        return trucks;
    }

    /**
     * 修改数据
     *
     * @param trucks 实例对象
     * @return 实例对象
     */
    @Override
    public Trucks update(Trucks trucks) {
        this.trucksDao.update(trucks);
        return this.queryById(trucks.getTid());
    }

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tid) {
        return this.trucksDao.deleteById(tid) > 0;
    }
}