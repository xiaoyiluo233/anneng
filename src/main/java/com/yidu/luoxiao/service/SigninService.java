package com.yidu.luoxiao.service;

import com.yidu.entity.Signin;
import java.util.List;

/**
 * (Signin)表服务接口
 *
 * @author makejava
 * @since 2021-01-06 11:00:33
 */
public interface SigninService {
    /**
     * 查询所有数据
     * @return
     */
    List<Signin> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param signid 主键
     * @return 实例对象
     */
    Signin queryById(Integer signid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Signin> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param signin 实例对象
     * @return 实例对象
     */
    Boolean insert(Signin signin);

    /**
     * 修改数据
     *
     * @param signin 实例对象
     * @return 实例对象
     */
    Boolean update(Signin signin);

    /**
     * 通过主键删除数据
     *
     * @param signid 主键
     * @return 是否成功
     */
    Boolean deleteById(Integer signid);

}