package com.yidu.lr.service;

import com.yidu.entity.Trucks;
import java.util.List;

/**
 * (Trucks)表服务接口
 *
 * @author makejava
 * @since 2021-02-22 09:19:37
 */
public interface TrucksService {

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    Trucks queryById(Integer tid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Trucks> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param trucks 实例对象
     * @return 实例对象
     */
    Trucks insert(Trucks trucks);

    /**
     * 修改数据
     *
     * @param trucks 实例对象
     * @return 实例对象
     */
    Trucks update(Trucks trucks);

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer tid);

}