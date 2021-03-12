package com.yidu.lixiang.service.impl;

import com.yidu.entity.Warerecord;
import com.yidu.lixiang.dao.WarerecordDao;
import com.yidu.lixiang.service.WarerecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 仓库记录表业务接口层
 * @author: lixiang
 * @date: 2021/3/11 18:29
 * @version 1.0
 */
@Service
public class WarerecordServiceImpl implements WarerecordService {
    @Autowired
    private WarerecordDao warerecordDao;

    /**
     * 连表查询出员工名、仓库名以及仓库记录表的基本数据
     * @return 数据集合
     */
    @Override
    public List<HashMap<String, Object>> getMainData() {
        //调用查询出员工名、仓库名以及仓库记录表的基本数据的方法
        List<HashMap<String, Object>> mainData = warerecordDao.getMainData();
        return mainData;
    }

    /**
     * 通过ID查询单条数据
     * @param wrid 主键
     * @return 实例对象
     */
    @Override
    public Warerecord queryById(Integer wrid) {
        return this.warerecordDao.queryById(wrid);
    }

    /**
     * 查询多条数据
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Warerecord> queryAllByLimit(int offset, int limit) {
        return this.warerecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     * @param warerecord 实例对象
     * @return 实例对象
     */
    @Override
    public Warerecord insert(Warerecord warerecord) {
        this.warerecordDao.insert(warerecord);
        return warerecord;
    }

    /**
     * 修改数据
     * @param warerecord 实例对象
     * @return 实例对象
     */
    @Override
    public Warerecord update(Warerecord warerecord) {
        this.warerecordDao.update(warerecord);
        return this.queryById(warerecord.getWrid());
    }

    /**
     * 通过主键删除数据
     * @param wrid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer wrid) {
        return this.warerecordDao.deleteById(wrid) > 0;
    }
}