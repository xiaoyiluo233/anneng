package com.yidu.lr.service.impl;

import com.yidu.entity.Province;
import com.yidu.lr.dao.LRProvinceDao;
import com.yidu.lr.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Province)表服务实现类
 *
 * @author makejava
 * @since 2021-01-08 18:09:40
 */
@Service
public class LRProvinceServiceImpl implements ProvinceService {
    @Autowired
    private LRProvinceDao provinceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param provinceid 主键
     * @return 实例对象
     */
    @Override
    public Province queryById(Integer provinceid) {
        return this.provinceDao.queryById(provinceid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Province> queryAllByLimit(int offset, int limit) {
        return this.provinceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param province 实例对象
     * @return 实例对象
     */
    @Override
    public Province insert(Province province) {
        this.provinceDao.insert(province);
        return province;
    }

    /**
     * 修改数据
     *
     * @param province 实例对象
     * @return 实例对象
     */
    @Override
    public Province update(Province province) {
        this.provinceDao.update(province);
        return this.queryById(province.getProvinceid());
    }

    /**
     * 通过主键删除数据
     *
     * @param provinceid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer provinceid) {
        return this.provinceDao.deleteById(provinceid) > 0;
    }
}