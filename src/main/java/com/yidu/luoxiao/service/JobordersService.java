package com.yidu.luoxiao.service;

import com.yidu.entity.Joborders;
import java.util.List;

/**
 * (Joborders)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 14:21:15
 */
public interface JobordersService {
    /**
     * 查询所有数据
     * @return
     */
    List<Joborders> querAll();

    /**
     * 通过ID查询单条数据
     *
     * @param jid 主键
     * @return 实例对象
     */
    Joborders queryById(Integer jid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Joborders> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param joborders 实例对象
     * @return 实例对象
     */
    Boolean insert(Joborders joborders);

    /**
     * 修改数据
     *
     * @param joborders 实例对象
     * @return 实例对象
     */
    Boolean update(Joborders joborders);

    /**
     * 通过主键删除数据
     *
     * @param jid 主键
     * @return 是否成功
     */
    Boolean deleteById(Integer jid);

}