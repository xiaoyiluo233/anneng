package com.yidu.lr.service.impl;

import com.yidu.entity.Trucks;
import com.yidu.lr.dao.LRTrucksDao;
import com.yidu.lr.service.TrucksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Trucks)表服务实现类
 *
 * @author makejava
 * @since 2021-02-22 09:19:37
 */
@Service("trucksService")
public class LRTrucksServiceImpl implements TrucksService {
    @Autowired
    private LRTrucksDao trucksDao;

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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Trucks> queryAllByLimit(int offset, int limit) {
        return this.trucksDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param trucks 实例对象
     * @return 实例对象
     */
    @Override
    public Trucks insert(Trucks trucks) {
        this.trucksDao.insert(trucks);
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

    @Override
    public Trucks queryByParcelid(Integer parcelid) {
        return trucksDao.queryByParcelid(parcelid);
    }

    @Override
    public List<Trucks> queryAll(Trucks trucks) {
        return trucksDao.queryAll(trucks);
    }

}