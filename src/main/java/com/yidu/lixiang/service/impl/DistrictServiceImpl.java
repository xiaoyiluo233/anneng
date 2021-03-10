package com.yidu.lixiang.service.impl;

import com.yidu.entity.District;
import com.yidu.lixiang.dao.DistrictDao;
import com.yidu.lixiang.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 县级表业务接口层
 * @author: lixiang
 * @date: 2020/12/30 15:47
 * @version 1.0
 */
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictDao districtDao;

    /**
     * 得到所有的区级集合
     * @param district 县级表实体类
     * @return 区级集合
     */
    @Override
    public List<District> getCity(District district) {
        return districtDao.getCity(district);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param districtid 主键
     * @return 实例对象
     */
    @Override
    public District queryById(Integer districtid) {
        return this.districtDao.queryById(districtid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<District> queryAllByLimit(int offset, int limit) {
        return this.districtDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param district 实例对象
     * @return 实例对象
     */
    @Override
    public District insert(District district) {
        this.districtDao.insert(district);
        return district;
    }

    /**
     * 修改数据
     *
     * @param district 实例对象
     * @return 实例对象
     */
    @Override
    public District update(District district) {
        this.districtDao.update(district);
        return this.queryById(district.getDistrictid());
    }

    /**
     * 通过主键删除数据
     *
     * @param districtid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer districtid) {
        return this.districtDao.deleteById(districtid) > 0;
    }
}