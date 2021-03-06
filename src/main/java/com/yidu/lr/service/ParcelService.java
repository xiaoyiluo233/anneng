package com.yidu.lr.service;

import com.yidu.entity.Parcel;
import com.yidu.lr.controller.vo.ParcelStationVo;

import java.util.List;
import java.util.Map;

/**
 * (Parcel)表服务接口
 *
 * @author makejava
 * @since 2021-01-01 17:39:15
 */
public interface ParcelService {

    /**
     * 通过ID查询单条数据
     *
     * @param parcelid 主键
     * @return 实例对象
     */
    Parcel queryById(Integer parcelid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Parcel> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param parcel 实例对象
     * @return 实例对象
     */
    int insert(Parcel parcel);

    /**
     * 修改数据
     *
     * @param parcel 实例对象
     * @return 实例对象
     */
    Parcel update(Parcel parcel);

    /**
     * 通过主键删除数据
     *
     * @param parcelid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer parcelid);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param parcel 实例对象
     * @return 对象列表
     */
    List<Parcel> queryAll(Parcel parcel);

    List<Map<String,Object>> OidFindIn(String[] OidStrArray);

    List<ParcelStationVo> selectConnect();

    Parcel queryIdMax();
}