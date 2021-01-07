package com.yidu.lr.service.impl;

import com.yidu.entity.District;
import com.yidu.lr.dao.DistrictDao;
import com.yidu.lr.service.DistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (District)表服务实现类
 *
 * @author makejava
 * @since 2021-01-01 15:05:04
 */
@Service("districtService")
public class DistrictServiceImpl implements DistrictService {
    @Resource
    private DistrictDao districtDao;

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