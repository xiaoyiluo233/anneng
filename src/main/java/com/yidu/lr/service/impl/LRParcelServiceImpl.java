package com.yidu.lr.service.impl;

import com.yidu.entity.Parcel;
import com.yidu.lr.controller.vo.ParcelStationVo;
import com.yidu.lr.dao.LRParcelDao;
import com.yidu.lr.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Parcel)表服务实现类
 *
 * @author makejava
 * @since 2021-01-01 17:39:15
 */
@Service
public class LRParcelServiceImpl implements ParcelService {
    @Autowired
    private LRParcelDao parcelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param parcelid 主键
     * @return 实例对象
     */
    @Override
    public Parcel queryById(Integer parcelid) {
        return this.parcelDao.queryById(parcelid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Parcel> queryAllByLimit(int offset, int limit) {
        return this.parcelDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param parcel 实例对象
     * @return 实例对象
     */
    @Override
    public Parcel insert(Parcel parcel) {
        this.parcelDao.insert(parcel);
        return parcel;
    }

    /**
     * 修改数据
     *
     * @param parcel 实例对象
     * @return 实例对象
     */
    @Override
    public Parcel update(Parcel parcel) {
        this.parcelDao.update(parcel);
        return this.queryById(parcel.getParcelid());
    }

    /**
     * 通过主键删除数据
     *
     * @param parcelid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer parcelid) {
        return this.parcelDao.deleteById(parcelid) > 0;
    }

    @Override
    public List<Parcel> queryAll(Parcel parcel) {
        return parcelDao.queryAll(parcel);
    }

    @Override
    public List<Map<String,Object>> OidFindIn(String[] OidStrArray) {
        return parcelDao.OidFindIn(OidStrArray);
    }

    @Override
    public List<ParcelStationVo> selectConnect() {
        return parcelDao.selectConnect();
    }
}